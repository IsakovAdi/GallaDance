package com.example.galladance.data.mappers

import com.example.galladance.data.models.ClubCardData
import com.example.galladance.data.models.FitnessClubData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubCard
import com.example.galladance.domain.models.FitnessClub

class MapClubCardToDomain(
    private val mapper: Mapper<FitnessClubData,FitnessClub>,
) : Mapper<ClubCardData, ClubCard> {
    override fun map(from: ClubCardData) = from.run {
        ClubCard(
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