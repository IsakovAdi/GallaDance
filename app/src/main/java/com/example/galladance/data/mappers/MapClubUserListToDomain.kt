package com.example.galladance.data.mappers

import com.example.galladance.data.models.ClubUserData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubUser

class MapClubUserListToDomain(
    private val mapper: Mapper<ClubUserData, ClubUser>,
) : Mapper<List<ClubUserData>, List<ClubUser>> {
    override fun map(from: List<ClubUserData>) = from.run {
        map(mapper::map)
    }
}