package com.example.galladance.data.models

class FitnessClubData(
    val id: Int,
    val clubIcon: Int,
    val clubLogo: Int,
    val clubTitle: String,
    val users: List<ClubUserData>,
    val clubAddress: String,
    var inClub: List<ClubUserData>,
    val challenges: ChallengeData,
    val lessons: List<LessonData>,
)