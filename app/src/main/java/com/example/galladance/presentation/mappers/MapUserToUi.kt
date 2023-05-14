package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.*
import com.example.galladance.presentation.models.*

class MapUserToUi(
    private val mapManager: Mapper<FitnessManager, FitnessManagerUi>,
    private val mapUsers: Mapper<List<ClubUser>, List<ClubUserUi>>,
    private val mapLessons: Mapper<List<Lesson>, List<LessonUi>>,
    private val mapAccounts: Mapper<List<Account>, List<AccountUi>>,
    private val mapCards: Mapper<List<ClubCard>, List<ClubCardUi>>,
    private val mapChallenges: Mapper<List<Challenge>, List<ChallengeUi>>,
    private val mapFitnessClub: Mapper<FitnessClub, FitnessClubUi>,
) : Mapper<User, UserUi> {
    override fun map(from: User) = from.run {
        UserUi(
            userId = userId,
            userName = userName,
            userImage = userImage,
            isInClub = isInClub,
            fitnessManager = mapManager.map(fitnessManager),
            userFriends = mapUsers.map(userFriends),
            lessons = mapLessons.map(lessons),
            accounts = mapAccounts.map(accounts),
            clubCards = mapCards.map(clubCards),
            challenges = mapChallenges.map(challenges),
            fitnessClub = mapFitnessClub.map(fitnessClub)
        )
    }
}