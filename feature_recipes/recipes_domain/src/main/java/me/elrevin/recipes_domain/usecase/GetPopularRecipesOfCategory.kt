package me.elrevin.recipes_domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import me.elrevin.recipes_domain.repository.RecipeRepository

class GetPopularRecipesOfCategory(private val repository: RecipeRepository) {
    operator fun invoke(categoryId: Int) =
        repository.getPopularRecipesOfCategory(categoryId).flowOn(Dispatchers.IO)
}
