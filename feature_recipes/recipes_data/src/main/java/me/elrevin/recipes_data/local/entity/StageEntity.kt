package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_stages")
data class StageEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val recipeId: Int,
)
