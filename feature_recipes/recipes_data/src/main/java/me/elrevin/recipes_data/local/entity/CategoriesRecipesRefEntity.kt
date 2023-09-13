package me.elrevin.recipes_data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "categories_recipes_ref",
    primaryKeys = [
        "recipeId",
        "categoryId"
    ]
)
data class CategoriesRecipesRefEntity(
    val recipeId: Int,
    val categoryId: Int,
)
