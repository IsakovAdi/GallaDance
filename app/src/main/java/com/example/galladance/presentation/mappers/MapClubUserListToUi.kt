package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubUser
import com.example.galladance.presentation.models.ClubUserUi

class MapClubUserListToUi(
    private val mapper: Mapper<ClubUser, ClubUserUi>,
) : Mapper<List<ClubUser>, List<ClubUserUi>> {
    override fun map(from: List<ClubUser>) = from.run {
        map(mapper::map)
    }
}