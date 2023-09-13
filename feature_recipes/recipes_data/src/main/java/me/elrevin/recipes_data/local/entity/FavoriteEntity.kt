package me.elrevin.recipes_data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "favorite_recipes",
    primaryKeys = [
        "recipeId", "sortIndex"
    ]
)
data class FavoriteEntity(
    val recipeId: Int,
    val sortIndex: Int
)
