package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_steps")
data class StepEntity(
    @PrimaryKey
    val id: Int,
    val photo: String?,
    val description: String,
    val stageId: Int?,
    val recipeId: Int?,
)
