package com.example.galladance.presentation.di

import com.example.galladance.data.mappers.cloud.*
import com.example.galladance.data.mappers.storage.MapSettingsStateFromData
import com.example.galladance.data.mappers.storage.MapSettingsStateToData
import com.example.galladance.data.models.*
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataMappersModule {

    // data

    @Provides
    fun provideMapSettingsStateFromData(): Mapper<SettingsStateData, SettingsState> =
        MapSettingsStateFromData()

    @Provides
    fun provideMapSettingsStateToData(): Mapper<SettingsState, SettingsStateData> =
        MapSettingsStateToData()

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
}