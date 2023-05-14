package com.example.galladance.data.mappers

import com.example.galladance.data.models.ChallengeData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge

class MapChallengeListToDomain(
    private val mapper: Mapper<ChallengeData, Challenge>,
) : Mapper<List<ChallengeData>, List<Challenge>> {
    override fun map(from: List<ChallengeData>) = from.run {
        map(mapper::map)
    }

}