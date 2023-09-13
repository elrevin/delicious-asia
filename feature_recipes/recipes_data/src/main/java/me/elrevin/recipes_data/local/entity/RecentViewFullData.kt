package me.elrevin.recipes_data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RecentViewFullData(
    @Embedded
    val recentView: RecentViewEntity,

    @Relation(
        entity = RecipeEntity::class,
        parentColumn = "recipeId",
        entityColumn = "id"
    )
    val recipe: RecipeFullData
)
