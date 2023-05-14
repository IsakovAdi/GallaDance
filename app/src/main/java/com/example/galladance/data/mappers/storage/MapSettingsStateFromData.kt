package com.example.galladance.data.mappers.storage

import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.SettingsState

class MapSettingsStateFromData:Mapper<SettingsStateData, SettingsState> {
    override fun map(from: SettingsStateData) = from.run {
        SettingsState(
            nowInClubVisibility = nowInClubVisibility,
            newChallengeVisibility = newChallengeVisibility,
            userChallengesVisibility = userChallengesVisibility,
            userCardsVisibility = userCardsVisibility,
            userAccountsVisibility = userAccountsVisibility,
            userTrainingsVisibility = userTrainingsVisibility,
            userFriendsVisibility = userFriendsVisibility,
        )
    }
}