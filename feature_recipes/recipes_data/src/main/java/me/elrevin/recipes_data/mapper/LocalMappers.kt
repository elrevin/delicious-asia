package me.elrevin.recipes_data.mapper

import me.elrevin.recipes_data.local.entity.AuthorEntity
import me.elrevin.recipes_data.local.entity.CategoryEntity
import me.elrevin.recipes_data.local.entity.CuisineEntity
import me.elrevin.recipes_data.local.entity.FavoriteEntity
import me.elrevin.recipes_data.local.entity.FavoriteFullData
import me.elrevin.recipes_data.local.entity.IngredientEntity
import me.elrevin.recipes_data.local.entity.IngredientValueEntity
import me.elrevin.recipes_data.local.entity.IngredientsValuesFullData
import me.elrevin.recipes_data.local.entity.RecentViewEntity
import me.elrevin.recipes_data.local.entity.RecentViewFullData
import me.elrevin.recipes_data.local.entity.RecipeEntity
import me.elrevin.recipes_data.local.entity.RecipeFullData
import me.elrevin.recipes_data.local.entity.StageEntity
import me.elrevin.recipes_data.local.entity.StageFullData
import me.elrevin.recipes_data.local.entity.StepEntity
import me.elrevin.recipes_data.local.entity.TrendEntity
import me.elrevin.recipes_data.local.entity.TrendFullData
import me.elrevin.recipes_domain.entity.Author
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Cuisine
import me.elrevin.recipes_domain.entity.Ingredient
import me.elrevin.recipes_domain.entity.IngredientValue
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_domain.entity.Stage
import me.elrevin.recipes_domain.entity.Step

fun AuthorEntity.toDomain() = Author(
    id, name, avatar
)

fun CategoryEntity.toDomain() = Category(id, name, viewsCount)

fun CuisineEntity.toDomain() = Cuisine(id, name)

fun IngredientEntity.toDomain() = Ingredient(id, name, icon)

fun IngredientsValuesFullData.toDomain() = IngredientValue(
    ingredient = ingredientEntity.toDomain(),
    optional = valueEntity.optional,
    amount = valueEntity.amount,
    unit = valueEntity.unit,
    constantAmount = valueEntity.constantAmount,
    toTaste = valueEntity.toTaste,
)

fun StepEntity.toDomain() = Step(id, photo, description)

fun StageFullData.toDomain() = Stage(
    id = stageEntity.id,
    name = stageEntity.name,
    steps = steps.map { it.toDomain() },
)

fun RecipeFullData.toDomain() = Recipe(
    id = recipeEntity.id,
    name = recipeEntity.name,
    duration = recipeEntity.duration,
    rate = recipeEntity.rate,
    viewsCount = recipeEntity.viewsCount,
    mainPhoto = recipeEntity.mainPhoto,
    cuisine = cuisine.toDomain(),
    author = author.toDomain(),
    categories = categories.map { it.toDomain() },
    ingredients = ingredients.map { it.toDomain() },
    stages = stages.map { it.toDomain() },
    steps = steps.map { it.toDomain() }
)


fun Author.toDb() = AuthorEntity(
    id, name, avatar
)

fun Category.toDb() = CategoryEntity(id, name, viewsCount)

fun Cuisine.toDb() = CuisineEntity(id, name)

fun Ingredient.toDb() = IngredientEntity(id, name, icon)

fun Recipe.toDb() = RecipeEntity(
    id = id,
    name = name,
    duration = duration,
    rate = rate,
    viewsCount = viewsCount,
    mainPhoto = mainPhoto,
    cuisineId = cuisine.id,
    authorId = author.id
)

fun Step.toDb(recipeId: Int?, stageId: Int?) = StepEntity(
    id = id, recipeId = recipeId, stageId = stageId, description = description, photo = photo
)

fun Stage.toDb(recipeId: Int) = StageFullData(
    stageEntity = StageEntity(id, name, recipeId),
    steps = steps.map { it.toDb(stageId = id, recipeId = null) }
)

fun IngredientValue.toDb(recipeId: Int) = IngredientsValuesFullData(
    ingredientEntity = ingredient.toDb(),
    valueEntity = IngredientValueEntity(
        recipeId = recipeId, ingredientId = ingredient.id,
        optional = optional, amount = amount, unit = unit, constantAmount = constantAmount,
        toTaste = toTaste
    )
)

fun Recipe.toDbFullData(): RecipeFullData = RecipeFullData(
    recipeEntity = toDb(),
    cuisine = cuisine.toDb(),
    categories = categories.map { it.toDb() },
    author = author.toDb(),
    ingredients = ingredients.map { it.toDb(id) },
    stages = stages.map { it.toDb(id) },
    steps = steps.map { it.toDb(recipeId = id, stageId = null) }
)

fun Recipe.toTrend(sortIndex: Int) = TrendFullData(
    trendEntity = TrendEntity(recipeId = id, sortIndex = sortIndex),
    recipe = toDbFullData()
)

fun Recipe.toFavorite(sortIndex: Int) = FavoriteFullData(
    favorite = FavoriteEntity(recipeId = id, sortIndex = sortIndex),
    recipe = toDbFullData()
)

fun Recipe.toRecentView(sortIndex: Int) = RecentViewFullData(
    recentView = RecentViewEntity(recipeId = id, sortIndex = sortIndex),
    recipe = toDbFullData()
)
