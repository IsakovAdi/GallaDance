package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.ClubCard
import com.example.galladance.domain.models.FitnessClub
import com.example.galladance.presentation.models.ClubCardUi
import com.example.galladance.presentation.models.FitnessClubUi

class MapClubCardToUi(
    private val mapper: Mapper<FitnessClub,FitnessClubUi>,
) : Mapper<ClubCard, ClubCardUi> {
    override fun map(from: ClubCard) = from.run {
        ClubCardUi(
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