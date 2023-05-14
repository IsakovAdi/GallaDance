package com.example.galladance.data.mappers

import com.example.galladance.data.models.*
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.*

class MapUserToDomain(
    private val mapManager: Mapper<FitnessManagerData, FitnessManager>,
    private val mapUsers: Mapper<List<ClubUserData>, List<ClubUser>>,
    private val mapLessons: Mapper<List<LessonData>, List<Lesson>>,
    private val mapAccounts: Mapper<List<AccountData>, List<Account>>,
    private val mapCards: Mapper<List<ClubCardData>, List<ClubCard>>,
    private val mapChallenges: Mapper<List<ChallengeData>, List<Challenge>>,
    private val mapFitnessClub: Mapper<FitnessClubData, FitnessClub>,
) : Mapper<UserData, User> {
    override fun map(from: UserData) = from.run {
        User(
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