package com.example.galladance.presentation.di

import com.example.galladance.data.cloud.mappers.*
import com.example.galladance.data.cloud.models.*
import com.example.galladance.data.mappers.*
import com.example.galladance.data.mappers.cloud.*
import com.example.galladance.data.models.*
import com.example.galladance.data.storage.mappers.MapSettingsStateFromStorage
import com.example.galladance.data.storage.mappers.MapSettingsStateToStorage
import com.example.galladance.data.storage.models.SettingsStateStorage
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
class CloudAndStorageMappersModule {
    // storage

    @Provides
    fun provideMapSettingsStateFromStorage(): Mapper<SettingsStateStorage, SettingsStateData> =
        MapSettingsStateFromStorage()

    @Provides
    fun provideMapSettingsStateToStorage(): Mapper<SettingsStateData, SettingsStateStorage> =
        MapSettingsStateToStorage()

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

}