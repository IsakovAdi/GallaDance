package com.example.galladance.data.cloud.example

import com.example.galladance.App.Companion.instance
import com.example.galladance.R
import com.example.galladance.data.cloud.models.*
import javax.inject.Inject
import kotlin.random.Random

const val UNIQ_START = 100
const val UNIQ_END = 999

class ExampleApi @Inject constructor() {
    private val clubUsers = getClubUsers()
    private val usersInClub = getInClub(clubUsers)
    private val challenge = getChallenge(10)
    private val lessons = getLessons()

    private val manager = FitnessManagerCloud(
        managerId = Random.nextInt(UNIQ_START, UNIQ_END),
        "Вячеслав Олегович Одиноков",
        "https://the-challenger.ru/wp-content/uploads/2019/01/Strukov.jpg"
    )

    private val fitnessClub = FitnessClubCloud(
        10,
        R.drawable.fitness_icon,
        R.drawable.fitness_club_icon,
        "Hope Fitness Атлант",
        users = clubUsers,
        clubAddress = "Сургут, Ленина 1",
        inClub = usersInClub,
        challenges = challenge,
        lessons = lessons,
    )
    private val accounts = listOf(
        AccountCloud(
            10,
            "personal",
            7345,
            fitnessClub = fitnessClub
        ),
        AccountCloud(
            20,
            "bonus",
            100,
            fitnessClub = fitnessClub
        )
    )
    private val clubCards = listOf(
        ClubCardCloud(
            id = 10,
            fitnessClub = fitnessClub,
            cardType = "Корпоративная",
            qr = R.drawable.qr_icon,
            isActive = getTurn(),
            activeDate = "2023-05-20",
            userVisit = 5,
            visitCount = 10,
            visitsLeft = 0,
        ),
        ClubCardCloud(
            id = 20,
            fitnessClub = fitnessClub,
            cardType = "Корпоративная",
            qr = R.drawable.qr_icon,
            isActive = getTurn(),
            activeDate = "2023-05-20",
            userVisit = 5,
            visitCount = 10,
            visitsLeft = 0,
        )
    )

    fun signIn(login: String, password: String): UserCloud =
        UserCloud(
            userId = Random.nextInt(UNIQ_START, UNIQ_END),
            userName = "Виктория Черняговская",
            userImage = "https://www.pngplay.com/wp-content/uploads/6/Fitness-Girl-PNG-Clipart-Background.png",
            isInClub = getTurn(),
            fitnessManager = manager,
            userFriends = clubUsers,
            lessons = lessons,
            accounts = accounts,
            clubCards = clubCards,
            challenges = getChallenges(),
            fitnessClub = fitnessClub
        )


    private fun getLessons(): List<LessonCloud> = listOf(
        LessonCloud(
            id = 10,
            title = "Хатха-йога",
            date = "2023-05-14",
            startTime = "11:30",
            endTime = "13:10",
            coach = CoachCloud(
                id = getRandom(),
                name = "Виктория Федорова",
                "https://www.vokrug.tv/pic/person/2/3/a/9/23a907049cd740df58817d6350017738.jpeg"
            ),
            space = "1 зал"
        ),
        LessonCloud(
            id = 20,
            title = "Elementary Gymnastics (7-13)",
            date = "2023-05-17",
            startTime = "11:30",
            endTime = "13:10",
            coach = CoachCloud(
                id = getRandom(),
                name = "Андрей Погожи",
                "data:image/jpeg;base64,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"
            ),
            space = "1 зал"
        ),
        LessonCloud(
            id = 30,
            title = "Хатха-йога",
            date = "2023-05-17",
            startTime = "11:30",
            endTime = "13:10",
            coach = CoachCloud(
                id = getRandom(),
                name = "Виктория Федорова",
                "https://www.vokrug.tv/pic/person/2/3/a/9/23a907049cd740df58817d6350017738.jpeg"
            ),
            space = "1 зал"
        )
    )

    private fun getChallenges(): List<ChallengeCloud> {
        val list = mutableListOf<ChallengeCloud>()
        for (i in 0..4) {
            list.add(getChallenge(i + 100))
        }
        return list
    }

    private fun getChallenge(id: Int): ChallengeCloud =
        ChallengeCloud(
            id = id,
            title = "Новый челлендж по калориям",
            icon = R.drawable.apple_icon,
            image = R.drawable.challenge_icon,
            startDate = "2023-05-20",
            endDate = "2023-05-30",
            prizeSpacesCount = 5,
            requirements = "6 000 шагов каждый день",
            description = instance.getString(R.string.challenge_desc_text),
            requirementsCount = 6000,
            userResult = 5000,
            userSpace = 6
        )

    private fun getInClub(list: List<ClubUserCloud>): List<ClubUserCloud> {
        val l = mutableListOf<ClubUserCloud>()
        for (i in list.indices) {
            if (list[i].isInClub) {
                l.add(list[i])
            }
        }
        return l
    }

    private fun getClubUsers(): List<ClubUserCloud> {
        val list = emptyList<ClubUserCloud>().toMutableList()
        for (i in 0..10) {
            list.add(
                ClubUserCloud(
                    i + 100,
                    getTurn(),
                    instance.getString(R.string.girl)
                )
            )
        }
        return list
    }


    private fun getTurn(): Boolean {
        val r = Random.nextInt(0, 10)
        return r % 2 == 0
    }

    private fun getRandom(): Int {
        return ((Math.random() * 1000) - 100).toInt()

    }

}