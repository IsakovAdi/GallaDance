package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ClubCardCloud
import com.example.galladance.data.cloud.models.FitnessClubCloud
import com.example.galladance.data.models.ClubCardData
import com.example.galladance.data.models.FitnessClubData
import com.example.galladance.domain.Mapper

class MapClubCardToData(
    private val mapper: Mapper<FitnessClubCloud, FitnessClubData>,
) : Mapper<ClubCardCloud, ClubCardData> {
    override fun map(from: ClubCardCloud) = from.run {
        ClubCardData(
            id = id,
            fitnessClub = mapper.map(fitnessClub),
            cardType = cardType,
            qr = qr,
            isActive = isActive,
            activeDate = activeDate,
            userVisit = userVisit,
            visitCount = visitCount,
            visitsLeft = visitsLeft,
        )
    }
}