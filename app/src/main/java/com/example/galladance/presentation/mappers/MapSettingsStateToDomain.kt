package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.SettingsState
import com.example.galladance.presentation.models.SettingsStateUi

class MapSettingsStateToDomain:Mapper<SettingsStateUi, SettingsState> {
    override fun map(from: SettingsStateUi) = from.run {
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