package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Coach
import com.example.galladance.presentation.models.CoachUi

class MapCoachToUi : Mapper<Coach, CoachUi> {
    override fun map(from: Coach) = from.run {
        CoachUi(
            id = id,
            name = name,
            image = image,
        )
    }
}