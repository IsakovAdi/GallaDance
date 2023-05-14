package com.example.galladance.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.galladance.R
import com.example.galladance.databinding.FragmentHomeBinding
import com.example.galladance.presentation.ui.HomeFragmentViewModel
import com.example.galladance.presentation.ui.adapters.account.AccountAdapter
import com.example.galladance.presentation.ui.adapters.friends.FriendsAdapter
import com.example.galladance.presentation.ui.adapters.lesson.LessonAdapter
import com.example.galladance.presentation.ui.adapters.nowInClub.NowInClubAdapter
import com.example.galladance.presentation.ui.adapters.userCard.CardsAdapter
import com.example.galladance.presentation.ui.adapters.userChallenges.UserChallengesAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<HomeFragmentViewModel>()

    private val accountAdapter by lazy {
        AccountAdapter()
    }

    private val friendsAdapter by lazy {
        FriendsAdapter()
    }

    private val lessonsAdapter by lazy {
        LessonAdapter()
    }

    private val nowInClubAdapter by lazy {
        NowInClubAdapter()
    }

    private val userClubCardsAdapter by lazy {
        CardsAdapter()
    }

    private val userChallengesAdapter by lazy {
        UserChallengesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding.toolbar.inflateMenu(R.menu.top_menu)
        binding.toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener,
            androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.search -> {
                        Log.d("MY_LOG", "Search")
                    }
                    R.id.settings -> {
                        Log.d("MY_LOG", "settings")
                    }
                    R.id.notifications -> {
                        Log.d("MY_LOG", "notif")
                    }
                }
                return true
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        viewModel.signIn("example", "example")
        observeViewModel()
        setupClickers()
    }

    private fun setupAdapters() {
        binding.apply {
            nowInClubLayout.nowInClubRv.adapter = nowInClubAdapter
            myChallengesLayout.myChallengesRv.adapter = userChallengesAdapter
            myClubCardsLayout.myClubCardsRv.adapter = userClubCardsAdapter
            myAccountsL.myAccountsRv.adapter = accountAdapter
            myTrainingsLayout.myTrainingsRv.adapter = lessonsAdapter
            myFriendsLayout.myFriendsRv.adapter = friendsAdapter
        }
    }

    private fun observeViewModel() {
        observeUserFriends()
        observeNowInClub()
        observeUserChallenges()
        observeUserClubCards()
        observeUserAccounts()
        observeLessons()
        observeAndSetupNewChallenge()
        observeUserAndSetup()
        observeIsChallengeVisible()
        observeFitnessClub()
        observeError()
    }

    private fun observeUserFriends() {
        viewModel.userFriends.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myFriendsLayout.apply {
                    root.visibility = View.VISIBLE
                    friendsAdapter.users = it
                    myFriendsCount.text = (it.size).toString()
                    if (it.size > FriendsAdapter.limit) {
                        moreThanTenFriendsText.text = "+ ${(it.size - FriendsAdapter.limit)}"
                    }
                }
            } else binding.myFriendsLayout.root.visibility = View.GONE
        }
    }

    private fun observeNowInClub() {
        viewModel.nowInClub.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.nowInClubLayout.root.visibility = View.VISIBLE
                nowInClubAdapter.users = it
                binding.nowInClubLayout.nowInClubCountText.text = (it.size).toString()
            } else binding.nowInClubLayout.root.visibility = View.GONE
        }
    }

    private fun observeUserChallenges() {
        viewModel.userChallenges.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myChallengesLayout.root.visibility = View.VISIBLE
                userChallengesAdapter.challenges = it
            } else binding.myChallengesLayout.root.visibility = View.GONE
        }
    }

    private fun observeUserClubCards() {
        viewModel.userClubCards.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myClubCardsLayout.root.visibility = View.VISIBLE
                userClubCardsAdapter.cards = it
            } else binding.myClubCardsLayout.root.visibility = View.GONE
        }
    }

    private fun observeUserAccounts() {
        viewModel.userAccounts.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myAccountsL.root.visibility = View.VISIBLE
                accountAdapter.accounts = it
            } else binding.myAccountsL.root.visibility = View.GONE
        }
    }

    private fun observeLessons() {
        viewModel.userLessons.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myTrainingsLayout.root.visibility = android.view.View.VISIBLE
                lessonsAdapter.submitList(it)
            } else binding.myTrainingsLayout.root.visibility = android.view.View.GONE
        }
    }

    private fun observeAndSetupNewChallenge() {
        viewModel.newChallenge.observe(viewLifecycleOwner) {
            binding.challengeLayout.apply {
                if (it != null) {
                    binding.challengeLayout.root.visibility = View.VISIBLE
                    challengeIcon.setImageResource(it.icon)
                    challengeTitleText.text = it.title
                    challengeDateText.text = "Старт через ${startAfterDays(it.startDate)} дней"
                    challengeCalendarText.text = convertChallengeDates(it.startDate, it.endDate)
                    prizeCountText.text = "${it.prizeSpacesCount} призовых мест"
                    challengeTypeText.text = it.requirements
                    challengeImage.setImageResource(it.image)
                    challengeDescText.text = it.description
                } else {
                    this.root.visibility = View.GONE
                }
            }
        }
    }

    private fun convertChallengeDates(startDate: String, endDate: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val start = LocalDate.parse(startDate, formatter)
            .format(DateTimeFormatter.ofPattern("dd.MM", Locale("RU")))

        val end = LocalDate.parse(endDate, formatter)
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        return "$start - $end"
    }

    private fun observeUserAndSetup() {
        viewModel.user.observe(viewLifecycleOwner) {
            binding.apply {
                Picasso.get().load(it.userImage).into(userAvatar)
                userNameText.text = it.userName
                homeScreenBottomViewsL.apply {
                    personalManagerNameText.text =
                        it.fitnessManager.managerName
                    Picasso.get().load(it.fitnessManager.managerImage)
                        .into(this.personalManagerImage)
                }
            }
        }
    }

    private fun observeIsChallengeVisible() {
        viewModel.isChallengeVisible.observe(viewLifecycleOwner) {
            if (it) {
                binding.apply {
                    challengeLayout.challengeDescCardView.visibility = View.VISIBLE
                    challengeLayout.hideText.text = "Свернуть"
                }
            } else {
                binding.apply {
                    challengeLayout.challengeDescCardView.visibility = View.GONE
                    challengeLayout.hideText.text = "Развернуть"
                }
            }
        }
    }

    private fun observeFitnessClub() {
        viewModel.fitnessClub.observe(viewLifecycleOwner) {
            binding.apply {
                fitnessIcon.setImageResource(it.clubIcon)
                clubNameText.text = it.clubTitle
                fitnessAddressText.text = it.clubAddress
            }
        }
    }

    private fun observeError() {
        viewModel.error.observe(viewLifecycleOwner) {
            makeToast(it)
        }
    }

    private fun setupClickers() {
        binding.challengeLayout.hideText.setOnClickListener {
            viewModel.changeChallengeVisibility()
        }
    }

    private fun startAfterDays(startDay: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(startDay, formatter)
        val currentDate = LocalDate.now()
        return (date.dayOfMonth - currentDate.dayOfMonth).toString()
    }

    private fun makeToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}