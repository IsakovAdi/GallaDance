package com.example.galladance.presentation.models

class FitnessClubUi(
    val id: Int,
    val clubIcon: Int,
    val clubLogo: Int,
    val clubTitle: String,
    val users: List<ClubUserUi>,
    val clubAddress: String,
    var inClub: List<ClubUserUi>,
    val challenges: ChallengeUi,
    val lessons: List<LessonUi>,
)