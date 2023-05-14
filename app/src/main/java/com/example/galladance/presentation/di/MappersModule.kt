package com.example.galladance.presentation.di

import com.example.galladance.data.cloud.mappers.*
import com.example.galladance.data.cloud.models.*
import com.example.galladance.data.mappers.*
import com.example.galladance.data.models.*
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.*
import com.example.galladance.presentation.mappers.*
import com.example.galladance.presentation.models.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {
    // cloud
    @Provides
    fun provideMapAccountListToData(
        mapper: Mapper<AccountCloud, AccountData>,
    ): Mapper<List<AccountCloud>, List<AccountData>> = MapAccountListToData(mapper = mapper)

    @Provides
    fun provideMapAccountToData(
        mapper: Mapper<FitnessClubCloud, FitnessClubData>,
    ): Mapper<AccountCloud, AccountData> = MapAccountToData(mapper = mapper)

    @Provides
    fun provideMapChallengeListToData(
        mapper: Mapper<ChallengeCloud, ChallengeData>,
    ): Mapper<List<ChallengeCloud>, List<ChallengeData>> = MapChallengeListToData(mapper = mapper)

    @Provides
    fun provideMapChallengeToData(): Mapper<ChallengeCloud, ChallengeData> = MapChallengeToData()

    @Provides
    fun provideMapClubCardListToData(
        mapper: Mapper<ClubCardCloud, ClubCardData>,
    ): Mapper<List<ClubCardCloud>, List<ClubCardData>> = MapClubCardListToData(mapper = mapper)

    @Provides
    fun provideMapClubCardToData(
        mapper: Mapper<FitnessClubCloud, FitnessClubData>,
    ): Mapper<ClubCardCloud, ClubCardData> = MapClubCardToData(mapper = mapper)

    @Provides
    fun provideMapClubUserListToData(
        mapper: Mapper<ClubUserCloud, ClubUserData>,
    ): Mapper<List<ClubUserCloud>, List<ClubUserData>> = MapClubUserListToData(mapper = mapper)

    @Provides
    fun provideMapClubUserToData(): Mapper<ClubUserCloud, ClubUserData> = MapClubUserToData()

    @Provides
    fun provideMapCoachToData(): Mapper<CoachCloud, CoachData> = MapCoachToData()

    @Provides
    fun provideMapFitnessClubToData(
        mapUser: Mapper<List<ClubUserCloud>, List<ClubUserData>>,
        mapChallenges: Mapper<ChallengeCloud, ChallengeData>,
        mapLessons: Mapper<List<LessonCloud>, List<LessonData>>,
    ): Mapper<FitnessClubCloud, FitnessClubData> =
        MapFitnessClubToData(
            mapUser = mapUser,
            mapChallenges = mapChallenges,
            mapLessons = mapLessons,
        )

    @Provides
    fun provideMapFitnessManagerToData(): Mapper<FitnessManagerCloud, FitnessManagerData> =
        MapFitnessManagerToData()

    @Provides
    fun provideMapLessonListToData(
        mapper: Mapper<LessonCloud, LessonData>,
    ): Mapper<List<LessonCloud>, List<LessonData>> = MapLessonListToData(mapper = mapper)

    @Provides
    fun provideMapLessonToData(
        mapper: Mapper<CoachCloud, CoachData>,
    ): Mapper<LessonCloud, LessonData> = MapLessonToData(mapper = mapper)

    @Provides
    fun provideMapUserToData(
        mapManager: Mapper<FitnessManagerCloud, FitnessManagerData>,
        mapUsers: Mapper<List<ClubUserCloud>, List<ClubUserData>>,
        mapLessons: Mapper<List<LessonCloud>, List<LessonData>>,
        mapAccounts: Mapper<List<AccountCloud>, List<AccountData>>,
        mapCards: Mapper<List<ClubCardCloud>, List<ClubCardData>>,
        mapChallenges: Mapper<List<ChallengeCloud>, List<ChallengeData>>,
        mapperFitnessClub: Mapper<FitnessClubCloud, FitnessClubData>,
    ): Mapper<UserCloud, UserData> = MapUserToData(
        mapManager = mapManager,
        mapUsers = mapUsers,
        mapLessons = mapLessons,
        mapAccounts = mapAccounts,
        mapCards = mapCards,
        mapChallenges = mapChallenges,
        mapFitnessClub = mapperFitnessClub
    )

    // data
    @Provides
    fun provideMapAccountListToDomain(
        mapper: Mapper<AccountData, Account>,
    ): Mapper<List<AccountData>, List<Account>> = MapAccountListToDomain(mapper = mapper)

    @Provides
    fun provideMapAccountToDomain(
        mapper: Mapper<FitnessClubData, FitnessClub>,
    ): Mapper<AccountData, Account> = MapAccountToDomain(mapper = mapper)

    @Provides
    fun provideMapChallengeListToDomain(
        mapper: Mapper<ChallengeData, Challenge>,
    ): Mapper<List<ChallengeData>, List<Challenge>> = MapChallengeListToDomain(mapper = mapper)

    @Provides
    fun provideMapChallengeToDomain(): Mapper<ChallengeData, Challenge> = MapChallengeToDomain()

    @Provides
    fun provideMapClubCardListToDomain(
        mapper: Mapper<ClubCardData, ClubCard>,
    ): Mapper<List<ClubCardData>, List<ClubCard>> = MapClubCardListToDomain(mapper = mapper)

    @Provides
    fun provideMapClubCardToDomain(
        mapper: Mapper<FitnessClubData, FitnessClub>,
    ): Mapper<ClubCardData, ClubCard> = MapClubCardToDomain(mapper = mapper)

    @Provides
    fun provideMapClubUserListToDomain(
        mapper: Mapper<ClubUserData, ClubUser>,
    ): Mapper<List<ClubUserData>, List<ClubUser>> = MapClubUserListToDomain(mapper = mapper)

    @Provides
    fun provideMapClubUserToDomain(): Mapper<ClubUserData, ClubUser> = MapClubUserToDomain()

    @Provides
    fun provideMapCoachToDomain(): Mapper<CoachData, Coach> = MapCoachToDomain()

    @Provides
    fun provideMapFitnessClubToDomain(
        mapUser: Mapper<List<ClubUserData>, List<ClubUser>>,
        mapChallenges: Mapper<ChallengeData, Challenge>,
        mapLessons: Mapper<List<LessonData>, List<Lesson>>,
    ): Mapper<FitnessClubData, FitnessClub> = MapFitnessClubToDomain(
        mapUser = mapUser,
        mapChallenges = mapChallenges,
        mapLessons = mapLessons
    )

    @Provides
    fun provideMapFitnessManagerToDomain(): Mapper<FitnessManagerData, FitnessManager> =
        MapFitnessManagerToDomain()

    @Provides
    fun provideMapLessonListToDomain(
        mapper: Mapper<LessonData, Lesson>,
    ): Mapper<List<LessonData>, List<Lesson>> = MapLessonListToDomain(mapper = mapper)

    @Provides
    fun provideMapLessonToDomain(
        mapper: Mapper<CoachData, Coach>,
    ): Mapper<LessonData, Lesson> = MapLessonToDomain(mapper = mapper)

    @Provides
    fun provideMapUserToDomain(
        mapManager: Mapper<FitnessManagerData, FitnessManager>,
        mapUsers: Mapper<List<ClubUserData>, List<ClubUser>>,
        mapLessons: Mapper<List<LessonData>, List<Lesson>>,
        mapAccounts: Mapper<List<AccountData>, List<Account>>,
        mapCards: Mapper<List<ClubCardData>, List<ClubCard>>,
        mapChallenges: Mapper<List<ChallengeData>, List<Challenge>>,
        mapFitnessClub: Mapper<FitnessClubData, FitnessClub>,
    ): Mapper<UserData, User> = MapUserToDomain(
        mapManager = mapManager,
        mapUsers = mapUsers,
        mapLessons = mapLessons,
        mapAccounts = mapAccounts,
        mapCards = mapCards,
        mapChallenges = mapChallenges,
        mapFitnessClub = mapFitnessClub
    )

    // presentation
    @Provides
    fun provideMapAccountListToUi(
        mapper: Mapper<Account, AccountUi>,
    ): Mapper<List<Account>, List<AccountUi>> = MapAccountListToUi(mapper = mapper)

    @Provides
    fun provideMapAccountToUi(
        mapper: Mapper<FitnessClub, FitnessClubUi>,
    ): Mapper<Account, AccountUi> = MapAccountToUi(mapper = mapper)

    @Provides
    fun provideMapChallengeListToUi(
        mapper: Mapper<Challenge, ChallengeUi>,
    ): Mapper<List<Challenge>, List<ChallengeUi>> = MapChallengeListToUi(mapper = mapper)

    @Provides
    fun provideMapChallengeToUi(): Mapper<Challenge, ChallengeUi> = MapChallengeToUi()

    @Provides
    fun provideMapClubCardListToUi(
        mapper: Mapper<ClubCard, ClubCardUi>,
    ): Mapper<List<ClubCard>, List<ClubCardUi>> = MapClubCardListToUi(mapper = mapper)

    @Provides
    fun provideMapClubCardToUi(
        mapper: Mapper<FitnessClub, FitnessClubUi>,
    ): Mapper<ClubCard, ClubCardUi> = MapClubCardToUi(mapper = mapper)

    @Provides
    fun provideMapClubUserListToUi(
        mapper: Mapper<ClubUser, ClubUserUi>,
    ): Mapper<List<ClubUser>, List<ClubUserUi>> = MapClubUserListToUi(mapper = mapper)

    @Provides
    fun provideMapClubUserToUi(): Mapper<ClubUser, ClubUserUi> = MapClubUserToUi()

    @Provides
    fun provideMapCoachToUi(): Mapper<Coach, CoachUi> = MapCoachToUi()

    @Provides
    fun provideMapFitnessClubToUi(
        mapUser: Mapper<List<ClubUser>, List<ClubUserUi>>,
        mapChallenges: Mapper<Challenge, ChallengeUi>,
        mapLessons: Mapper<List<Lesson>, List<LessonUi>>,
    ): Mapper<FitnessClub, FitnessClubUi> =
        MapFitnessClubToUi(
            mapUser = mapUser,
            mapChallenges = mapChallenges,
            mapLessons = mapLessons
        )

    @Provides
    fun provideMapFitnessManagerToUi(): Mapper<FitnessManager, FitnessManagerUi> =
        MapFitnessManagerToUi()

    @Provides
    fun provideMapLessonListToUi(
        mapper: Mapper<Lesson, LessonUi>,
    ): Mapper<List<Lesson>, List<LessonUi>> = MapLessonListToUi(mapper = mapper)

    @Provides
    fun provideMapLessonToUi(
        mapper: Mapper<Coach, CoachUi>,
    ): Mapper<Lesson, LessonUi> = MapLessonToUi(mapper = mapper)

    @Provides
    fun provideMapUserToUi(
        mapManager: Mapper<FitnessManager, FitnessManagerUi>,
        mapUsers: Mapper<List<ClubUser>, List<ClubUserUi>>,
        mapLessons: Mapper<List<Lesson>, List<LessonUi>>,
        mapAccounts: Mapper<List<Account>, List<AccountUi>>,
        mapCards: Mapper<List<ClubCard>, List<ClubCardUi>>,
        mapChallenges: Mapper<List<Challenge>, List<ChallengeUi>>,
        mapFitnessClub: Mapper<FitnessClub, FitnessClubUi>,
    ): Mapper<User, UserUi> = MapUserToUi(
        mapManager = mapManager,
        mapUsers = mapUsers,
        mapLessons = mapLessons,
        mapAccounts = mapAccounts,
        mapCards = mapCards,
        mapChallenges = mapChallenges,
        mapFitnessClub = mapFitnessClub
    )

}