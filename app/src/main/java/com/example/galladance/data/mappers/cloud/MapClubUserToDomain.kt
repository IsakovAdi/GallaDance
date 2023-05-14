package com.example.galladance.data.mappers.cloud

import com.example.galladance.data.models.ClubUserData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubUser

class MapClubUserToDomain : Mapper<ClubUserData, ClubUser> {
    override fun map(from: ClubUserData) = from.run {
        ClubUser(
            id = id,
            isInClub = isInClub,
            image = image
        )
    }
}