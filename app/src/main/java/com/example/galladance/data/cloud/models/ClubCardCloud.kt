package com.example.galladance.data.cloud.models

class ClubCardCloud(
    val id: Int,
    val fitnessClub: FitnessClubCloud,
    val cardType: String,
    val qr: Int,
    val isActive: Boolean,
    val activeDate: String,
    val userVisit: Int,
    val visitCount: Int,
    val visitsLeft: Int,
)