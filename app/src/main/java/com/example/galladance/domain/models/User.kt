package com.example.galladance.domain.models

class User(
    val userId: Int,
    var userName: String,
    var userImage: String,
    var isInClub: Boolean,
    var fitnessManager: FitnessManager,
    var userFriends: List<ClubUser>,
    var lessons: List<Lesson>,
    var accounts: List<Account>,
    var clubCards: List<ClubCard>,
    var challenges: List<Challenge>,
    val fitnessClub:FitnessClub
)