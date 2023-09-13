package me.elrevin.recipes_data.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import me.elrevin.core.getLocale

data class RecipeFullData(

    @Embedded
    val recipeEntity: RecipeEntity,

    @Relation(
        parentColumn = "cuisineId",
        entityColumn = "id"
    )
    val cuisine: CuisineEntity,

    @Relation(
        parentColumn = "authorId",
        entityColumn = "id"
    )
    val author: AuthorEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = CategoriesRecipesRefEntity::class,
            parentColumn = "recipeId",
            entityColumn = "categoryId"
        )
    )
    val categories: List<CategoryEntity>,

    @Relation(
        entity = IngredientValueEntity::class,
        parentColumn = "id",
        entityColumn = "recipeId",
    )
    val ingredients: List<IngredientsValuesFullData>,

    @Relation(
        entity = StageEntity::class,
        parentColumn = "id",
        entityColumn = "recipeId"
    )
    val stages: List<StageFullData>,

    @Relation(
        parentColumn = "id",
        entityColumn = "recipeId"
    )
    val steps: List<StepEntity>
) {
    /**
     * Returns rating of the recipe in formatted string value
     */
    fun getRating(): String = "%.1f".format(getLocale(), this)
}
