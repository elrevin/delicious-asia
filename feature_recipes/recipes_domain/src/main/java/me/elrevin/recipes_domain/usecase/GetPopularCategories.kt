package me.elrevin.recipes_domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import me.elrevin.recipes_domain.repository.RecipeRepository

class GetPopularCategories (private val repository: RecipeRepository) {
    operator fun invoke() = repository.getPopularCategories().flowOn(Dispatchers.IO)
}
