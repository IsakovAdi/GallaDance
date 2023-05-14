package com.example.galladance.domain.models

data class SettingsState(
    val nowInClubVisibility: Boolean,
    val newChallengeVisibility: Boolean,
    val userChallengesVisibility: Boolean,
    val userCardsVisibility: Boolean,
    val userAccountsVisibility: Boolean,
    val userTrainingsVisibility: Boolean,
    val userFriendsVisibility: Boolean,
)