package me.elrevin.recipes_data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class StageFullData(

    @Embedded
    val stageEntity: StageEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "stageId"
    )
    val steps: List<StepEntity>,
)
