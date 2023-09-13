package me.elrevin.recipes_domain.entity

import me.elrevin.core.getLocale

data class Recipe(
    val id: Int,
    val name: String,
    val duration: Int,
    val rate: Double,
    val viewsCount: Int,
    val mainPhoto: String,
    val cuisine: Cuisine,
    val author: Author,
    val categories: List<Category>,
    val ingredients: List<IngredientValue>,
    val stages: List<Stage>,
    val steps: List<Step>
) {
    /**
     * Returns rating of the recipe in formatted string value
     */
    fun getRating(): String = "%.1f".format(getLocale(), this.rate)
}
