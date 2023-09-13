package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_categories")
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val viewsCount: Int,
    val modifiedAt: Long = System.currentTimeMillis(),
)
