package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ClubUserCloud
import com.example.galladance.data.models.ClubUserData
import com.example.galladance.domain.Mapper

class MapClubUserListToData(
    private val mapper: Mapper<ClubUserCloud, ClubUserData>,
) : Mapper<List<ClubUserCloud>, List<ClubUserData>> {
    override fun map(from: List<ClubUserCloud>) = from.run {
        map(mapper::map)
    }
}