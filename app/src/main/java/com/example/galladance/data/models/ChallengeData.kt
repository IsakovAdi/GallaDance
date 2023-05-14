package com.example.galladance.data.models

class ChallengeData(
    val id: Int,
    val title: String,
    val icon: Int,
    val image: Int,
    val startDate: String,
    val endDate: String,
    val prizeSpacesCount: Int,
    val requirements: String,
    val description: String,
    val requirementsCount: Int,
    var userResult: Int,
    var userSpace: Int,
)