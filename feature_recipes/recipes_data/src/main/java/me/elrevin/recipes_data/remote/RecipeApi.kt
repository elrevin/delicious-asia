package me.elrevin.recipes_data.remote

import me.elrevin.core.Either
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe

interface RecipeApi {
    suspend fun loadTrends(): Either<List<Recipe>>
    suspend fun loadCategories(): Either<List<Category>>
    suspend fun loadRecipesOfCategory(categoryId: Int): Either<List<Recipe>>
}