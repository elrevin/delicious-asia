package me.elrevin.recipes_domain.entity

data class Stage(
    val id: Int,
    val name: String,
    val steps: List<Step>
)
