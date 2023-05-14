package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Challenge
import com.example.galladance.domain.models.ClubUser
import com.example.galladance.domain.models.FitnessClub
import com.example.galladance.domain.models.Lesson
import com.example.galladance.presentation.models.ChallengeUi
import com.example.galladance.presentation.models.ClubUserUi
import com.example.galladance.presentation.models.FitnessClubUi
import com.example.galladance.presentation.models.LessonUi

class MapFitnessClubToUi(
    private val mapUser: Mapper<List<ClubUser>, List<ClubUserUi>>,
    private val mapChallenges: Mapper<Challenge, ChallengeUi>,
    private val mapLessons: Mapper<List<Lesson>, List<LessonUi>>,
) : Mapper<FitnessClub, FitnessClubUi> {
    override fun map(from: FitnessClub) = from.run {
        FitnessClubUi(
            id = id,
            clubIcon = clubIcon,
            clubLogo = clubLogo,
            clubTitle = clubTitle,
            users = mapUser.map(users),
            clubAddress = clubAddress,
            inClub = mapUser.map(inClub),
            challenges = mapChallenges.map(challenges),
            lessons = mapLessons.map(lessons),
        )
    }
}