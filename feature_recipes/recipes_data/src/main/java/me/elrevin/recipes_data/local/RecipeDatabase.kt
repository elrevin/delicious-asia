package me.elrevin.recipes_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import me.elrevin.recipes_data.local.entity.AuthorEntity
import me.elrevin.recipes_data.local.entity.CategoriesRecipesRefEntity
import me.elrevin.recipes_data.local.entity.CategoryEntity
import me.elrevin.recipes_data.local.entity.CuisineEntity
import me.elrevin.recipes_data.local.entity.FavoriteEntity
import me.elrevin.recipes_data.local.entity.IngredientEntity
import me.elrevin.recipes_data.local.entity.IngredientValueEntity
import me.elrevin.recipes_data.local.entity.RecentViewEntity
import me.elrevin.recipes_data.local.entity.RecipeEntity
import me.elrevin.recipes_data.local.entity.StageEntity
import me.elrevin.recipes_data.local.entity.StepEntity
import me.elrevin.recipes_data.local.entity.TrendEntity

@Database(
    entities = [
        AuthorEntity::class,
        CategoryEntity::class,
        CuisineEntity::class,
        IngredientEntity::class,
        IngredientValueEntity::class,
        CategoriesRecipesRefEntity::class,
        RecipeEntity::class,
        StageEntity::class,
        StepEntity::class,
        FavoriteEntity::class,
        TrendEntity::class,
        RecentViewEntity::class
    ],
    version = 3
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}