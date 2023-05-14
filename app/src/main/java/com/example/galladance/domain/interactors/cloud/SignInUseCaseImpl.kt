package com.example.galladance.domain.interactors.cloud

import com.example.galladance.domain.models.Challenge
import com.example.galladance.domain.models.User
import com.example.galladance.domain.repositories.Repository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : SignInUseCase {
    override suspend fun invoke(login: String, password: String): User {

        val user = repository.signIn(login = login, password = password)

        user.challenges = convertChallengeDaysLeft(user.challenges)
        user.clubCards.forEach {
            it.visitsLeft = it.visitCount - it.userVisit
        }
        user.fitnessClub.challenges.daysLeft =
            getLeftDays(user.fitnessClub.challenges.endDate)

        return user
    }


    private fun convertChallengeDaysLeft(list: List<Challenge>): List<Challenge> {
        val l = list
        l.forEach {
            it.daysLeft = getLeftDays(it.endDate)
        }
        return l
    }

    private fun getLeftDays(challengeEndDate: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(challengeEndDate, formatter)
        val currentDate = LocalDate.now()
        return (date.dayOfMonth - currentDate.dayOfMonth).toString()
    }
}