package me.elrevin.recipes_data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "ingredients_recipes_ref",
    primaryKeys = ["recipeId", "ingredientId"]
)
data class IngredientValueEntity(
    val recipeId: Int,
    val ingredientId: Int,
    val optional: Boolean,
    val amount: Double,
    val unit: String?,
    val constantAmount: Boolean,
    val toTaste: Boolean,
)
