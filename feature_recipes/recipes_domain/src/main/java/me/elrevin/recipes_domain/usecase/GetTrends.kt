package me.elrevin.recipes_domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import me.elrevin.recipes_domain.repository.RecipeRepository

class GetTrends(
    private val repository: RecipeRepository
) {
    operator fun invoke() = repository.getTrends().flowOn(Dispatchers.IO)
}