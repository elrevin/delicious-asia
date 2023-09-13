package me.elrevin.recipes_data.di

import android.content.Context
import androidx.room.Room
import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.elrevin.recipes_data.RecipeRepositoryImpl
import me.elrevin.recipes_data.local.RecipeDao
import me.elrevin.recipes_data.local.RecipeDatabase
import me.elrevin.recipes_data.remote.RecipeApi
import me.elrevin.recipes_data.remote.RecipeApiImpl
import me.elrevin.recipes_domain.repository.RecipeRepository
import me.elrevin.user_account_domain.UserAccountUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext context: Context
    ): RecipeDatabase = Room
        .databaseBuilder(context, RecipeDatabase::class.java, "recipe_database")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(
        db: RecipeDatabase
    ): RecipeDao = db.recipeDao()

    @Provides
    @Singleton
    fun provideRecipeApi(
        apolloClient: ApolloClient,
        userAccountUseCases: UserAccountUseCases
    ): RecipeApi = RecipeApiImpl(apolloClient, userAccountUseCases)

    @Provides
    @Singleton
    fun provideRecipeRepository(
        api: RecipeApi,
        dao: RecipeDao
    ): RecipeRepository = RecipeRepositoryImpl(api, dao)
}