package me.elrevin.recipes_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.elrevin.recipes_domain.repository.RecipeRepository
import me.elrevin.recipes_domain.usecase.GetPopularCategories
import me.elrevin.recipes_domain.usecase.GetPopularRecipesOfCategory
import me.elrevin.recipes_domain.usecase.GetTrends
import me.elrevin.recipes_domain.usecase.RecipeUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideUseCases(
        repository: RecipeRepository
    ): RecipeUseCases = RecipeUseCases(
        getTrends = GetTrends(repository),
        getPopularCategories = GetPopularCategories(repository),
        getPopularRecipesOfCategory = GetPopularRecipesOfCategory(repository),
    )
}