package me.elrevin.recipes_data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "trends_recipes",
    primaryKeys = [
        "recipeId", "sortIndex"
    ]
)
data class TrendEntity(
    val recipeId: Int,
    val sortIndex: Int
)
