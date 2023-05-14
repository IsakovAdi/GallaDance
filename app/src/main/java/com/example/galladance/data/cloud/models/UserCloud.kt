package com.example.galladance.data.cloud.models

class UserCloud(
    val userId: Int,
    val userName: String,
    val userImage: String,
    val isInClub: Boolean,
    val fitnessManager: FitnessManagerCloud,
    val userFriends: List<ClubUserCloud>,
    val lessons: List<LessonCloud>,
    val accounts: List<AccountCloud>,
    val clubCards: List<ClubCardCloud>,
    val challenges: List<ChallengeCloud>,
    val fitnessClub:FitnessClubCloud
)