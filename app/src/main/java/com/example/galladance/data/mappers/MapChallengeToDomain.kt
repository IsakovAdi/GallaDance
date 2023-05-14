package com.example.galladance.data.mappers

import com.example.galladance.data.models.ChallengeData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge

class MapChallengeToDomain : Mapper<ChallengeData, Challenge> {
    override fun map(from: ChallengeData) = from.run {
        Challenge(
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
            daysLeft = ""
        )
    }
}