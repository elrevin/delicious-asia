package me.elrevin.recipes_domain.repository

import kotlinx.coroutines.flow.Flow
import me.elrevin.core.Either
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe

interface RecipeRepository {
    fun getTrends(): Flow<Either<List<Recipe>>>

    fun getPopularCategories(): Flow<Either<List<Category>>>

    fun getPopularRecipesOfCategory(categoryId: Int): Flow<Either<List<Recipe>>>
}