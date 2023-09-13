package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val duration: Int,
    val rate: Double,
    val viewsCount: Int,
    val mainPhoto: String,
    val cuisineId: Int,
    val authorId: Int,
    val modifiedAt: Long = System.currentTimeMillis(),
)
