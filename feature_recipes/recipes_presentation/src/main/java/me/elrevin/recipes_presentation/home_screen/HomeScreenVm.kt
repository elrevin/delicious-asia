package me.elrevin.recipes_presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_domain.usecase.RecipeUseCases
import javax.inject.Inject

@HiltViewModel
class HomeScreenVm @Inject constructor(
    private val recipeUseCases: RecipeUseCases
) : ViewModel() {
    var state by mutableStateOf(HomeScreenState())
        private set

    init {
        getTrends()
        getPopularCategories()
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnChangeActiveCategory -> setActiveCategory(event.categoryId)
        }
    }

    private fun setActiveCategory(categoryId: Int) {
        state = state.copy(activeCategory = categoryId)
        getRecipesPopularCategory(categoryId)
    }

    private fun getTrends() {
        viewModelScope.launch {
            recipeUseCases.getTrends().collect {
                when {
                    it.isLoading() -> state = state.copy(loadingTrends = true, error = null)
                    it.isSuccess() -> state =
                        state.copy(trends = it.getValue(), loadingTrends = false, error = null)

                    it.isException() -> state = state.copy(loadingTrends = false, error = 1)
                }
            }
        }
    }

    private fun getPopularCategories() {
        viewModelScope.launch {
            recipeUseCases.getPopularCategories().collect {
                when {
                    it.isLoading() -> state = state.copy(loadingCategories = true, error = null)
                    it.isSuccess() -> {
                        val categories = it.getValue()
                        if (categories.isNotEmpty()) {
                            state = state.copy(
                                popularCategories = it.getValue(),
                                loadingCategories = false,
                                error = null,
                            )
                            if (state.activeCategory == null) {
                                setActiveCategory(categories.first().id)
                            }
                        }
                    }

                    it.isException() -> state = state.copy(loadingTrends = false, error = 1)
                }
            }
        }
    }

    private var getRecipesPopularCategoryJob: Job? = null
    private fun getRecipesPopularCategory(categoryId: Int) {
        if (getRecipesPopularCategoryJob != null) {
            getRecipesPopularCategoryJob!!.cancel()
        }
        getRecipesPopularCategoryJob = viewModelScope.launch {
            recipeUseCases.getPopularRecipesOfCategory(categoryId).collect {
                when {
                    it.isLoading() -> state = state.copy(loadingRecipesOfCategory = true, error = null)
                    it.isSuccess() -> {
                        val recipes = it.getValue()
                        if (recipes.isNotEmpty()) {
                            state = state.copy(
                                recipesOfCategory = it.getValue(),
                                loadingRecipesOfCategory = false,
                                error = null,
                            )
                        }
                    }

                    it.isException() -> state = state.copy(loadingRecipesOfCategory = false, error = 1)
                }
            }
        }
    }
}

data class HomeScreenState(
    val trends: List<Recipe> = listOf(),
    val loadingTrends: Boolean = false,

    val activeCategory: Int? = null,
    val popularCategories: List<Category> = listOf(),
    val loadingCategories: Boolean = false,

    val recipesOfCategory: List<Recipe> = listOf(),
    val loadingRecipesOfCategory: Boolean = false,

    val error: Int? = null
) {
    val showLoadingTrendsProgress: Boolean
        get() = trends.isEmpty() && loadingTrends

    val showLoadingPopularCategories: Boolean
        get() = popularCategories.isEmpty() && loadingCategories

    val showLoadingRecipesOfCategory: Boolean
        get() = recipesOfCategory.isEmpty() && loadingRecipesOfCategory
}

sealed class HomeScreenEvent {
    class OnChangeActiveCategory(val categoryId: Int): HomeScreenEvent()
}