package me.elrevin.recipes_data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "recent_view_recipes",
    primaryKeys = [
        "recipeId", "sortIndex"
    ]
)
data class RecentViewEntity(
    val recipeId: Int,
    val sortIndex: Int
)
