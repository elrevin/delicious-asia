package me.elrevin.recipes_data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class IngredientsValuesFullData (
    @Embedded
    val valueEntity: IngredientValueEntity,

    @Relation(
        parentColumn = "ingredientId",
        entityColumn = "id"
    )
    val ingredientEntity: IngredientEntity,
)