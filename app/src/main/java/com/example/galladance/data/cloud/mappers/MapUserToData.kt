package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.*
import com.example.galladance.data.models.*
import com.example.galladance.domain.Mapper

class MapUserToData(
    private val mapManager: Mapper<FitnessManagerCloud, FitnessManagerData>,
    private val mapUsers: Mapper<List<ClubUserCloud>, List<ClubUserData>>,
    private val mapLessons: Mapper<List<LessonCloud>, List<LessonData>>,
    private val mapAccounts: Mapper<List<AccountCloud>, List<AccountData>>,
    private val mapCards: Mapper<List<ClubCardCloud>, List<ClubCardData>>,
    private val mapChallenges: Mapper<List<ChallengeCloud>, List<ChallengeData>>,
    private val mapFitnessClub: Mapper<FitnessClubCloud, FitnessClubData>,
) : Mapper<UserCloud, UserData> {
    override fun map(from: UserCloud) = from.run {
        UserData(
            userId = userId,
            userName = userName,
            userImage = userImage,
            isInClub = isInClub,
            fitnessManager = mapManager.map(fitnessManager) ,
            userFriends = mapUsers.map(userFriends),
            lessons = mapLessons.map(lessons ),
            accounts = mapAccounts.map(accounts ),
            clubCards = mapCards.map(clubCards ),
            challenges = mapChallenges.map(challenges),
            fitnessClub =mapFitnessClub.map(fitnessClub)
        )
    }
}