package com.example.galladance.presentation.di

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
class UiMappersModule {
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

    @Provides
    fun provideMapSettingsStateToDomain(): Mapper<SettingsStateUi, SettingsState> =
        MapSettingsStateToDomain()

    @Provides
    fun provideMapSettingsStateToUi(): Mapper<SettingsState, SettingsStateUi> =
        MapSettingsStateToUi()
}