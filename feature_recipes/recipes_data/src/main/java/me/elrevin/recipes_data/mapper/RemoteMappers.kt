package me.elrevin.recipes_data.mapper

import me.elrevin.recipes_data.fragment.CategoryFragment
import me.elrevin.recipes_data.fragment.RecipeFragment
import me.elrevin.recipes_data.fragment.StepFragment
import me.elrevin.recipes_domain.entity.Author
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Cuisine
import me.elrevin.recipes_domain.entity.Ingredient
import me.elrevin.recipes_domain.entity.IngredientValue
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_domain.entity.Stage
import me.elrevin.recipes_domain.entity.Step

fun CategoryFragment.toDomain() = Category(id, name, viewsCount)

fun RecipeFragment.Cuisine.toDomain() = Cuisine(id, name)

fun RecipeFragment.Author.toDomain() = Author(id, name, avatar)

fun RecipeFragment.Ingredient.toDomain() = Ingredient(
    id = id, name = name, icon = icon
)

fun RecipeFragment.Ingredient.toIngredientValue() = IngredientValue(
    ingredient = toDomain(),
    optional = optional,
    amount = amount,
    unit = unit,
    constantAmount = constantAmount,
    toTaste = toTaste
)

fun StepFragment.toDomain() = Step(id, photo, description)

fun RecipeFragment.Stage.toDomain() = Stage(
    id = id, name = name, steps = steps.map { it.stepFragment.toDomain() }
)

fun RecipeFragment.toDomain() = Recipe(
    id = id, name = name, duration = duration, rate = rate, viewsCount = viewsCount, mainPhoto = mainPhoto,
    cuisine = cuisine.toDomain(), author = author.toDomain(),
    categories = categories.map { it.categoryFragment.toDomain() },
    ingredients = ingredients.map { it.toIngredientValue() }, stages = stages.map { it.toDomain() },
    steps = steps.map { it.stepFragment.toDomain() }
)