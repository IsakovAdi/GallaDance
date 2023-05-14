package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ClubCardCloud
import com.example.galladance.data.models.ClubCardData
import com.example.galladance.domain.Mapper

class MapClubCardListToData(
    private val mapper: Mapper<ClubCardCloud, ClubCardData>,
) : Mapper<List<ClubCardCloud>, List<ClubCardData>> {
    override fun map(from: List<ClubCardCloud>) = from.run {
        map(mapper::map)
    }
}