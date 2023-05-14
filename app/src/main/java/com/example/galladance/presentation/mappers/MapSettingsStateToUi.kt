package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.SettingsState
import com.example.galladance.presentation.models.SettingsStateUi

class MapSettingsStateToUi : Mapper<SettingsState, SettingsStateUi> {
    override fun map(from: SettingsState) = from.run {
        SettingsStateUi(
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