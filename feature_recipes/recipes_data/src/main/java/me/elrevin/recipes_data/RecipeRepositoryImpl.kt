package me.elrevin.recipes_data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import me.elrevin.core.Either
import me.elrevin.recipes_data.local.RecipeDao
import me.elrevin.recipes_data.local.entity.TrendEntity
import me.elrevin.recipes_data.local.entity.TrendFullData
import me.elrevin.recipes_data.mapper.toDb
import me.elrevin.recipes_data.mapper.toDbFullData
import me.elrevin.recipes_data.mapper.toDomain
import me.elrevin.recipes_data.remote.RecipeApi
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    val api: RecipeApi,
    val dao: RecipeDao
) : RecipeRepository {

    override fun getTrends(): Flow<Either<List<Recipe>>> = merge(
        loadTrends().filter { !it.isSuccess() }.map { Either.fromEither(it) },
        dao.getTrends().map {
            Either.success(it.map { item -> item.recipe.toDomain() })
        }
    )

    private fun loadTrends(): Flow<Either<Unit>> = flow {
        emit(Either.loading())
        val res = api.loadTrends()
        if (res.isSuccess()) {
            dao.insertTrends(res.getValue().mapIndexed { index, recipe ->
                TrendFullData(
                    trendEntity = TrendEntity(recipe.id, index),
                    recipe = recipe.toDbFullData()
                )
            })
            emit(Either.success())
        } else {
            emit(Either.fromEither(res))
        }
    }

    override fun getPopularCategories(): Flow<Either<List<Category>>> = merge(
        loadCategories().filter { !it.isSuccess() }.map { Either.fromEither(it) },
        dao.getCategories(5).map {
            Either.success(it.map{ cat -> cat.toDomain()})
        }
    )


    private fun loadCategories(): Flow<Either<Unit>> = flow {
        val res = api.loadCategories()

        if (res.isSuccess()) {
            dao.insertCategories(res.getValue().map {
                it.toDb()
            })

            emit (Either.success())
        } else {
            emit (Either.fromEither(res))
        }
    }

    override fun getPopularRecipesOfCategory(categoryId: Int): Flow<Either<List<Recipe>>> = merge(
        loadPopularRecipesOfCategory(categoryId).filter { !it.isSuccess() }.map { Either.fromEither(it) },
        dao.getRecipesOfCategory(categoryId, 10, 0).map {
            Either.success(it.map{recipe -> recipe.toDomain()})
        }
    )

    private fun loadPopularRecipesOfCategory(categoryId: Int): Flow<Either<Unit>> = flow {
        val res = api.loadRecipesOfCategory(categoryId)
        if (res.isSuccess()) {
            dao.insertRecipes(res.getValue().map {
                it.toDbFullData()
            })

            emit(Either.success())
        } else {
            emit(Either.fromEither(res))
        }
    }
}