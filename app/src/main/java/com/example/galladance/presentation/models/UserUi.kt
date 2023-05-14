package com.example.galladance.presentation.models

class UserUi(
    val userId: Int,
    var userName: String,
    var userImage: String,
    var isInClub: Boolean,
    var fitnessManager: FitnessManagerUi,
    var userFriends: List<ClubUserUi>,
    var lessons: List<LessonUi>,
    var accounts: List<AccountUi>,
    var clubCards: List<ClubCardUi>,
    var challenges: List<ChallengeUi>,
    val fitnessClub: FitnessClubUi
)