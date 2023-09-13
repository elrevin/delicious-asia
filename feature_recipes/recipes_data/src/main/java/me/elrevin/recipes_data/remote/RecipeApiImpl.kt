package me.elrevin.recipes_data.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Query
import me.elrevin.core.Either
import me.elrevin.core.getLanguage
import me.elrevin.recipes_data.GetCategoriesQuery
import me.elrevin.recipes_data.GetRecipesQuery
import me.elrevin.recipes_data.mapper.toDomain
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.user_account_domain.UserAccountUseCases
import javax.inject.Inject

class RecipeApiImpl @Inject constructor(
    private val apolloClient: ApolloClient,
    private val userAccountUseCases: UserAccountUseCases
) : RecipeApi {
    suspend fun doLoadRecipes(query: Query<GetRecipesQuery.Data>): Either<List<Recipe>> {
        try {
            val response = apolloClient.query(
                query
            ).execute().dataAssertNoErrors

            if (response.recipes?.items == null) {
                throw Exception("Load trends query returns NULL")
            }

            val list: List<Recipe> = response.recipes.items.map { it.recipeFragment.toDomain() }


            return Either.success(list)
        } catch (e: Exception) {
            return Either.exception(e)
        }
    }

    override suspend fun loadTrends(): Either<List<Recipe>> =
        doLoadRecipes(
            GetRecipesQuery(
                getLanguage(),
                token = userAccountUseCases.getUser()?.token ?: "",
                favorites = false,
                page = 0,
                pageSize = 10,
                categories = null
            )
        )

    suspend fun doLoadCategories(query: Query<GetCategoriesQuery.Data>): Either<List<Category>> {
        return try {
            val response = apolloClient.query(
                query
            ).execute().dataAssertNoErrors

            val list: List<Category> = response.categories.map { it.categoryFragment.toDomain() }

            Either.success(list)
        } catch (e: Exception) {
            Either.exception(e)
        }
    }

    override suspend fun loadCategories(): Either<List<Category>> =
        doLoadCategories(GetCategoriesQuery(getLanguage()))


    override suspend fun loadRecipesOfCategory(categoryId: Int): Either<List<Recipe>> =
        doLoadRecipes(
            GetRecipesQuery(
                getLanguage(),
                token = userAccountUseCases.getUser()?.token ?: "",
                favorites = false,
                page = 0,
                pageSize = 10,
                categories = listOf(categoryId)
            )
        )
}