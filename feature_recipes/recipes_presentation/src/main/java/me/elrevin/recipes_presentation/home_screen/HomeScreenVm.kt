package me.elrevin.recipes_presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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
                    it.isLoading() -> state = state.copy(error = null)
                    it.isSuccess() -> state =
                        state.copy(trends = it.getValue(), error = null)

                    it.isException() -> state = state.copy(error = 1)
                }
            }
        }
    }

    private fun getPopularCategories() {
        viewModelScope.launch {
            recipeUseCases.getPopularCategories().collect {
                when {
                    it.isLoading() -> state = state.copy(error = null)
                    it.isSuccess() -> {
                        val categories = it.getValue()
                        if (categories.isNotEmpty()) {
                            state = state.copy(
                                popularCategories = it.getValue(),
                                error = null,
                            )
                            if (state.activeCategory == null) {
                                setActiveCategory(categories.first().id)
                            }
                        }
                    }

                    it.isException() -> state = state.copy(error = 1)
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
                    it.isLoading() -> state = state.copy(error = null, loadingRecipesOfCategory = true)
                    it.isSuccess() -> {
                        state = state.copy(error = null, loadingRecipesOfCategory = false)
                        val recipes = it.getValue()
                        if (recipes.isNotEmpty()) {
                            state = state.copy(recipesOfCategory = it.getValue())
                        } else if (state.loadingRecipesOfCategory) {
                            // if nothing was returned from database, but loading from api is still continuing,
                            // show shimmers
                            state = state.copy(recipesOfCategory = listOf(null, null, null, null, null))
                        }
                    }

                    it.isException() -> state = state.copy(error = 1, loadingRecipesOfCategory = false)
                }
            }
        }
    }
}

data class HomeScreenState(
    val trends: List<Recipe?> = listOf(null, null, null, null, null),
    val activeCategory: Int? = null,
    val popularCategories: List<Category?> = listOf(null, null, null, null, null),
    val recipesOfCategory: List<Recipe?> = listOf(null, null, null, null, null),
    val loadingRecipesOfCategory: Boolean = false,
    val error: Int? = null
)

sealed class HomeScreenEvent {
    class OnChangeActiveCategory(val categoryId: Int): HomeScreenEvent()
}