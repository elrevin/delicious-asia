package me.elrevin.recipes_data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TrendFullData(
    @Embedded
    val trendEntity: TrendEntity,

    @Relation(
        entity = RecipeEntity::class,
        parentColumn = "recipeId",
        entityColumn = "id"
    )
    val recipe: RecipeFullData
)
