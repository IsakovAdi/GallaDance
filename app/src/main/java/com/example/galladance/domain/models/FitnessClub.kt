package com.example.galladance.domain.models

data class FitnessClub(
    val id: Int,
    val clubIcon: Int,
    val clubLogo: Int,
    val clubTitle: String,
    val users: List<ClubUser>,
    val clubAddress: String,
    var inClub: List<ClubUser>,
    val challenges: Challenge,
    val lessons: List<Lesson>,
)