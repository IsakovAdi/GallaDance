package com.example.galladance.data.mappers

import com.example.galladance.data.models.ChallengeData
import com.example.galladance.data.models.ClubUserData
import com.example.galladance.data.models.FitnessClubData
import com.example.galladance.data.models.LessonData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge
import com.example.galladance.domain.models.ClubUser
import com.example.galladance.domain.models.FitnessClub
import com.example.galladance.domain.models.Lesson

class MapFitnessClubToDomain(
    private val mapUser: Mapper<List<ClubUserData>, List<ClubUser>>,
    private val mapChallenges: Mapper<ChallengeData, Challenge>,
    private val mapLessons: Mapper<List<LessonData>, List<Lesson>>,
) : Mapper<FitnessClubData, FitnessClub> {
    override fun map(from: FitnessClubData) = from.run {
        FitnessClub(
            id = id,
            clubIcon = clubIcon,
            clubLogo = clubLogo,
            clubTitle = clubTitle,
            users = mapUser.map(users ),
            clubAddress = clubAddress,
            inClub = mapUser.map(inClub ),
            challenges =  mapChallenges.map(challenges),
            lessons = mapLessons.map(lessons ),
        )
    }
}