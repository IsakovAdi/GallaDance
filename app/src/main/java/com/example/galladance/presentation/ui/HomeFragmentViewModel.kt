package com.example.galladance.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galladance.data.cloud.base.ResourceProvider
import com.example.galladance.data.cloud.example.ExampleApi
import com.example.galladance.data.cloud.models.*
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.interactors.SignInUseCase
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
    private val resourceProvider: ResourceProvider,
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

    fun signIn(login: String, password: String) = viewModelScope.launch {
        _user.value = mapper.map(signInUseCase(login = login, password = password))
        initLiveDates()
    }

    private fun initLiveDates() {
        _user.value.apply {
            _nowInClub.value = if (getTurn()) {
                this?.fitnessClub?.inClub ?: emptyList()
            } else emptyList()
            _challenge.value = if (getTurn()) {
                this?.fitnessClub?.challenges
            } else null
            _userChallenges.value = if (getTurn()) {
                this?.challenges
            } else emptyList()
            _userCards.value = if (getTurn()) {
                this?.clubCards
            } else emptyList()
            _userAccounts.value = if (getTurn()) {
                this?.accounts
            } else emptyList()
            _userLessons.value = if (getTurn()) {
                this?.lessons
            } else emptyList()
            _userFriends.value = if (getTurn()) {
                this?.userFriends
            } else emptyList()
            _fitnessClub.value = this?.fitnessClub
        }
    }

    fun changeChallengeVisibility() {
        _isChallengeVisible.value = _isChallengeVisible.value != true
    }

    private fun getTurn(): Boolean {
        val r = Random.nextInt(0, 10)
        return r % 2 == 0
    }
}