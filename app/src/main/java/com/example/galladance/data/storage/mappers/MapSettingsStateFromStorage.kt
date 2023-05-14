package com.example.galladance.data.storage.mappers

import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.data.storage.models.SettingsStateStorage
import com.example.galladance.domain.Mapper

class MapSettingsStateFromStorage:Mapper<SettingsStateStorage, SettingsStateData> {
    override fun map(from: SettingsStateStorage) = from.run {
        SettingsStateData(
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