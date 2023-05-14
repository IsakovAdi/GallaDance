package com.example.galladance.data.cloud.models

class FitnessClubCloud(
    val id: Int,
    val clubIcon: Int,
    val clubLogo: Int,
    val clubTitle: String,
    val users: List<ClubUserCloud>,
    val clubAddress: String,
    var inClub: List<ClubUserCloud>,
    val challenges: ChallengeCloud,
    val lessons: List<LessonCloud>,
)