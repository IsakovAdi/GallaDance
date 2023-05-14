package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge
import com.example.galladance.presentation.models.ChallengeUi

class MapChallengeListToUi(
    private val mapper: Mapper<Challenge, ChallengeUi>,
) : Mapper<List<Challenge>, List<ChallengeUi>> {
    override fun map(from: List<Challenge>) = from.run {
        map(mapper::map)
    }

}