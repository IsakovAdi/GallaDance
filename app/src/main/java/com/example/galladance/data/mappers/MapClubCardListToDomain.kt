package com.example.galladance.data.mappers

import com.example.galladance.data.models.ClubCardData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubCard

class MapClubCardListToDomain(
    private val mapper: Mapper<ClubCardData,ClubCard>,
) : Mapper<List<ClubCardData>, List<ClubCard>> {
    override fun map(from: List<ClubCardData>) = from.run {
        map(mapper::map)
    }
}