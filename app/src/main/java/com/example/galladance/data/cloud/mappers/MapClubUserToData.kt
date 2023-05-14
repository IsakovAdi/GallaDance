package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ClubUserCloud
import com.example.galladance.data.models.ClubUserData
import com.example.galladance.domain.Mapper

class MapClubUserToData : Mapper<ClubUserCloud, ClubUserData> {
    override fun map(from: ClubUserCloud) = from.run {
        ClubUserData(
            id = id,
            isInClub = isInClub,
            image = image
        )
    }
}