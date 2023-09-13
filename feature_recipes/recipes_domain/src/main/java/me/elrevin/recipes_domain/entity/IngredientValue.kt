package me.elrevin.recipes_domain.entity

data class IngredientValue(
    val ingredient: Ingredient,
    val optional: Boolean,
    val amount: Double,
    val unit: String?,
    val constantAmount: Boolean,
    val toTaste: Boolean,
)
