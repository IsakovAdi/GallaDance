package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.*
import com.example.galladance.data.models.*
import com.example.galladance.domain.Mapper

class MapFitnessClubToData(
    private val mapUser: Mapper<List<ClubUserCloud>, List<ClubUserData>>,
    private val mapChallenges: Mapper<ChallengeCloud, ChallengeData>,
    private val mapLessons: Mapper<List<LessonCloud>, List<LessonData>>,
) : Mapper<FitnessClubCloud, FitnessClubData> {
    override fun map(from: FitnessClubCloud) = from.run {
        FitnessClubData(
            id = id,
            clubIcon = clubIcon,
            clubLogo = clubLogo,
            clubTitle = clubTitle,
            users = mapUser.map(users),
            clubAddress = clubAddress,
            inClub = mapUser.map(inClub ),
            challenges = mapChallenges.map(challenges),
            lessons = mapLessons.map(lessons),
        )
    }
}