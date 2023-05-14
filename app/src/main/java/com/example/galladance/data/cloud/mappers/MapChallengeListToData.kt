package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ChallengeCloud
import com.example.galladance.data.models.ChallengeData
import com.example.galladance.domain.Mapper

class MapChallengeListToData(
    private val mapper: Mapper<ChallengeCloud, ChallengeData>,
) : Mapper<List<ChallengeCloud>, List<ChallengeData>> {
    override fun map(from: List<ChallengeCloud>) = from.run {
        map(mapper::map)
    }

}