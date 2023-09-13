package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuisines")
data class CuisineEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val modifiedAt: Long = System.currentTimeMillis(),
)
