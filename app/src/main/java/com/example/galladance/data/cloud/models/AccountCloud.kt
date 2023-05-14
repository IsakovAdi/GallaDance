package com.example.galladance.data.cloud.models


class AccountCloud(
    val accountId: Int,
    val accountType: String,
    val accountSum: Int,
    val fitnessClub: FitnessClubCloud,
)