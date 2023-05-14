package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubUser
import com.example.galladance.presentation.models.ClubUserUi

class MapClubUserToUi : Mapper<ClubUser, ClubUserUi> {
    override fun map(from: ClubUser) = from.run {
        ClubUserUi(
            id = id,
            isInClub = isInClub,
            image = image
        )
    }
}