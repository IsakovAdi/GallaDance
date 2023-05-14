package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.CoachCloud
import com.example.galladance.data.models.CoachData
import com.example.galladance.domain.Mapper

class MapCoachToData : Mapper<CoachCloud, CoachData> {
    override fun map(from: CoachCloud) = from.run {
        CoachData(
            id = id,
            name = name,
            image = image,
        )
    }
}