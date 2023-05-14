package com.example.galladance.data.mappers.cloud

import com.example.galladance.data.models.CoachData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Coach

class MapCoachToDomain : Mapper<CoachData, Coach> {
    override fun map(from: CoachData) = from.run {
        Coach(
            id = id,
            name = name,
            image = image,
        )
    }
}