package me.elrevin.recipes_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val avatar: String?,
    val modifiedAt: Long = System.currentTimeMillis(),
)
