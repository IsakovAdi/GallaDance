package com.example.galladance.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.interactors.cloud.SignInUseCase
import com.example.galladance.domain.interactors.storage.GetSettingsStateUseCase
import com.example.galladance.domain.interactors.storage.SaveSettingsStateUseCase
import com.example.galladance.domain.models.SettingsState
import com.example.galladance.domain.models.User
import com.example.galladance.presentation.models.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val mapper: Mapper<User, UserUi>,
    private val saveSettings: SaveSettingsStateUseCase,
    private val getSettingsState: GetSettingsStateUseCase,
    private val mapSettingsStateToUi: Mapper<SettingsState, SettingsStateUi>,
    private val mapSettingsStateToDomain: Mapper<SettingsStateUi, SettingsState>,
) : ViewModel() {

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private val _user: MutableLiveData<UserUi> = MutableLiveData()
    val user: LiveData<UserUi> get() = _user

    private val _fitnessClub: MutableLiveData<FitnessClubUi> = MutableLiveData()
    val fitnessClub: LiveData<FitnessClubUi> get() = _fitnessClub

    private val _nowInClub: MutableLiveData<List<ClubUserUi>> = MutableLiveData()
    val nowInClub: LiveData<List<ClubUserUi>> get() = _nowInClub

    private val _challenge: MutableLiveData<ChallengeUi> = MutableLiveData()
    val newChallenge: LiveData<ChallengeUi> get() = _challenge

    private val _userChallenges: MutableLiveData<List<ChallengeUi>> = MutableLiveData()
    val userChallenges: LiveData<List<ChallengeUi>> get() = _userChallenges

    private val _userCards: MutableLiveData<List<ClubCardUi>> = MutableLiveData()
    val userClubCards: LiveData<List<ClubCardUi>> get() = _userCards

    private val _userAccounts: MutableLiveData<List<AccountUi>> = MutableLiveData()
    val userAccounts: LiveData<List<AccountUi>> get() = _userAccounts

    private val _userLessons: MutableLiveData<List<LessonUi>> = MutableLiveData()
    val userLessons: LiveData<List<LessonUi>> get() = _userLessons

    private val _userFriends: MutableLiveData<List<ClubUserUi>> = MutableLiveData()
    val userFriends: LiveData<List<ClubUserUi>> get() = _userFriends

    private val _isChallengeVisible: MutableLiveData<Boolean> = MutableLiveData(true)
    val isChallengeVisible: LiveData<Boolean> get() = _isChallengeVisible

    private val _settingsState: MutableLiveData<SettingsStateUi> =
        MutableLiveData(SettingsStateUi())
    val settingsState: LiveData<SettingsStateUi> get() = _settingsState

    init {
        viewModelScope.launch {
            _settingsState.value = mapSettingsStateToUi.map(getSettingsState.invoke())
        }
    }

    fun signIn(login: String, password: String) = viewModelScope.launch {
        _user.value = mapper.map(signInUseCase(login = login, password = password))
        initLiveDates()
    }

    private fun initLiveDates() {
        _user.value.apply {
            _nowInClub.value = this?.fitnessClub?.inClub ?: emptyList()
            _challenge.value = this?.fitnessClub?.challenges
            _userChallenges.value = this?.challenges
            _userCards.value = this?.clubCards
            _userAccounts.value = this?.accounts
            _userLessons.value = this?.lessons
            _userFriends.value = this?.userFriends
            _fitnessClub.value = this?.fitnessClub
        }
    }

    fun changeChallengeVisibility() {
        _isChallengeVisible.value = _isChallengeVisible.value != true
    }

    fun changeStates(
        nowInClubState: Boolean,
        newChallengeState: Boolean,
        userChallengesState: Boolean,
        userCardsState: Boolean,
        userAccountsState: Boolean,
        userTrainingsState: Boolean,
        userFriendsState: Boolean,
    ) {
        _settingsState.value = SettingsStateUi(
            nowInClubVisibility = nowInClubState,
            newChallengeVisibility = newChallengeState,
            userChallengesVisibility = userChallengesState,
            userCardsVisibility = userCardsState,
            userAccountsVisibility = userAccountsState,
            userTrainingsVisibility = userTrainingsState,
            userFriendsVisibility = userFriendsState,
        )
        viewModelScope.launch {
            saveSettingsState()
        }
    }

    private fun saveSettingsState() = viewModelScope.launch {
        saveSettings(mapSettingsStateToDomain.map(_settingsState.value!!))
    }

}