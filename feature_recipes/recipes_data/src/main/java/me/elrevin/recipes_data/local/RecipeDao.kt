package me.elrevin.recipes_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import me.elrevin.recipes_data.local.entity.AuthorEntity
import me.elrevin.recipes_data.local.entity.CategoriesRecipesRefEntity
import me.elrevin.recipes_data.local.entity.CategoryEntity
import me.elrevin.recipes_data.local.entity.CuisineEntity
import me.elrevin.recipes_data.local.entity.IngredientEntity
import me.elrevin.recipes_data.local.entity.IngredientValueEntity
import me.elrevin.recipes_data.local.entity.RecipeEntity
import me.elrevin.recipes_data.local.entity.RecipeFullData
import me.elrevin.recipes_data.local.entity.StageEntity
import me.elrevin.recipes_data.local.entity.StepEntity
import me.elrevin.recipes_data.local.entity.TrendEntity
import me.elrevin.recipes_data.local.entity.TrendFullData

@Dao
interface RecipeDao {
    @Transaction
    @Query("SELECT * FROM trends_recipes ORDER BY sortIndex")
    fun getTrends(): Flow<List<TrendFullData>>

    @Transaction
    suspend fun insertTrends(list: List<TrendFullData>) {
        clearTrends()
        list.forEach {
            insertRecipe(it.recipe)
            insertTrend(it.trendEntity)
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrend(item: TrendEntity)

    @Query("DELETE FROM trends_recipes")
    suspend fun clearTrends()


    @Transaction
    suspend fun insertRecipe(item: RecipeFullData) {
        insertCategories(item.categories)
        insertCuisines(listOf(item.cuisine))
        insertIngredients(item.ingredients.map { iv -> iv.ingredientEntity })
        insertIngredientsValues(item.ingredients.map { iv -> iv.valueEntity })
        insertAuthors(listOf(item.author))
        insertSteps(item.steps)
        insertSteps(item.stages.flatMap{ stage -> stage.steps })
        insertStages(item.stages.map { s -> s.stageEntity })
        insertRecipe(item.recipeEntity)
    }

    @Transaction
    suspend fun insertRecipes(list: List<RecipeFullData>) {
        list.forEach {
            insertCategories(it.categories)
            insertCuisines(listOf(it.cuisine))
            insertIngredients(it.ingredients.map { iv -> iv.ingredientEntity })
            insertIngredientsValues(it.ingredients.map { iv -> iv.valueEntity })
            insertAuthors(listOf(it.author))
            insertSteps(it.steps)
            insertSteps(it.stages.flatMap{ stage -> stage.steps })
            insertStages(it.stages.map { s -> s.stageEntity })
            insertRecipe(it.recipeEntity)
            insertRecipeCategories(
                it.categories.map { cat ->
                    CategoriesRecipesRefEntity(
                        recipeId = it.recipeEntity.id,
                        categoryId = cat.id
                    )
                }
            )
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeCategories(list: List<CategoriesRecipesRefEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(list: List<CategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCuisines(list: List<CuisineEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthors(list: List<AuthorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredients(list: List<IngredientEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredientsValues(list: List<IngredientValueEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStages(list: List<StageEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSteps(list: List<StepEntity>)

    @Query("SELECT * FROM recipe_categories ORDER BY viewsCount LIMIT :count")
    fun getCategories(count: Int): Flow<List<CategoryEntity>>

    @Transaction
    @Query("SELECT * FROM recipes r LEFT JOIN categories_recipes_ref c ON r.id = c.recipeId " +
            "WHERE c.categoryId = :categoryId ORDER BY r.viewsCount DESC LIMIT :count OFFSET :offset")
    fun getRecipesOfCategory(categoryId: Int, count: Int, offset: Int): Flow<List<RecipeFullData>>
}