package com.example.galladance.data.models

class ClubCardData(
    val id: Int,
    val fitnessClub: FitnessClubData,
    val cardType: String,
    val qr: Int,
    val isActive: Boolean,
    val activeDate: String,
    val userVisit: Int,
    val visitCount: Int,
    val visitsLeft: Int,
)