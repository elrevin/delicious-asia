package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val icon: String?,
    val modifiedAt: Long = System.currentTimeMillis(),
)
