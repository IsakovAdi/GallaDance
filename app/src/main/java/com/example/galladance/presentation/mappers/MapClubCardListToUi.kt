package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubCard
import com.example.galladance.presentation.models.ClubCardUi

class MapClubCardListToUi(
    private val mapper: Mapper<ClubCard,ClubCardUi>,
) : Mapper<List<ClubCard>, List<ClubCardUi>> {
    override fun map(from: List<ClubCard>) = from.run {
        map(mapper::map)
    }
}