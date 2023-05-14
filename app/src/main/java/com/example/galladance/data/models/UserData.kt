package com.example.galladance.data.models

class UserData(
    val userId: Int,
    val userName: String,
    val userImage: String,
    val isInClub: Boolean,
    val fitnessManager: FitnessManagerData,
    val userFriends: List<ClubUserData>,
    val lessons: List<LessonData>,
    val accounts: List<AccountData>,
    val clubCards: List<ClubCardData>,
    val challenges: List<ChallengeData>,
    val fitnessClub: FitnessClubData
)