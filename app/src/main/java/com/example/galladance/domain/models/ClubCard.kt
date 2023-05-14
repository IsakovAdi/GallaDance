package com.example.galladance.domain.models

data class ClubCard(
    val id: Int,
    val fitnessClub: FitnessClub,
    val cardType: String,
    val qr: Int,
    val isActive: Boolean,
    val activeDate: String,
    val userVisit: Int,
    val visitCount: Int,
    var visitsLeft: Int,
)