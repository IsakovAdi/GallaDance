package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.ChallengeCloud
import com.example.galladance.data.models.ChallengeData
import com.example.galladance.domain.Mapper

class MapChallengeToData : Mapper<ChallengeCloud, ChallengeData> {
    override fun map(from: ChallengeCloud) = from.run {
        ChallengeData(
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
        )
    }
}