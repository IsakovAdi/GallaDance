package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge
import com.example.galladance.presentation.models.ChallengeUi

class MapChallengeToUi : Mapper<Challenge, ChallengeUi> {
    override fun map(from: Challenge) = from.run {
        ChallengeUi(
            id = id,
            title = title,
            icon = icon,
            image = image,
            startDate = startDate,
            endDate = endDate,
            prizeSpacesCount = prizeSpacesCount,
            requirements = requirements,
            description = description,
            requirementsCount = requirementsCount,
            userResult = userResult,
            userSpace = userSpace,
            daysLeft = daysLeft
        )
    }
}