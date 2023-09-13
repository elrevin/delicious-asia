package me.elrevin.recipes_domain.usecase

data class RecipeUseCases(
    val getTrends: GetTrends,

    val getPopularCategories: GetPopularCategories,

    val getPopularRecipesOfCategory: GetPopularRecipesOfCategory,
)
