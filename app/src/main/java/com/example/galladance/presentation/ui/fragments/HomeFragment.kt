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
import com.example.galladance.databinding.SettingsDialogItemBinding
import com.example.galladance.presentation.ui.HomeFragmentViewModel
import com.example.galladance.presentation.ui.adapters.account.AccountAdapter
import com.example.galladance.presentation.ui.adapters.friends.FriendsAdapter
import com.example.galladance.presentation.ui.adapters.lesson.LessonAdapter
import com.example.galladance.presentation.ui.adapters.nowInClub.NowInClubAdapter
import com.example.galladance.presentation.ui.adapters.userCard.CardsAdapter
import com.example.galladance.presentation.ui.adapters.userChallenges.UserChallengesAdapter
import com.example.galladance.presentation.ui.makeView
import com.google.android.material.bottomsheet.BottomSheetDialog
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
                        makeToast("Search")
                    }
                    R.id.settings -> {
                        openDialog()
                    }
                    R.id.notifications -> {
                        makeToast("Notifications")
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
        observeSettingsState()
    }

    private fun observeUserFriends() {
        viewModel.userFriends.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.myFriendsLayout.apply {
                    friendsAdapter.users = it
                    myFriendsCount.text = (it.size).toString()
                    if (it.size > FriendsAdapter.limit) {
                        moreThanTenFriendsText.text = "+ ${(it.size - FriendsAdapter.limit)}"
                    }
                }
            }
        }
    }

    private fun observeNowInClub() {
        viewModel.nowInClub.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                nowInClubAdapter.users = it
                binding.nowInClubLayout.nowInClubCountText.text = (it.size).toString()
            }
        }
    }

    private fun observeUserChallenges() {
        viewModel.userChallenges.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                userChallengesAdapter.challenges = it
            }
        }
    }

    private fun observeUserClubCards() {
        viewModel.userClubCards.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                userClubCardsAdapter.cards = it
            }
        }
    }

    private fun observeUserAccounts() {
        viewModel.userAccounts.observe(viewLifecycleOwner) {
            if (it.isNotEmpty())
                accountAdapter.accounts = it
        }
    }

    private fun observeLessons() {
        viewModel.userLessons.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                lessonsAdapter.submitList(it)
            }
        }
    }

    private fun observeAndSetupNewChallenge() {
        viewModel.newChallenge.observe(viewLifecycleOwner) {
            binding.challengeLayout.apply {
                if (it != null) {
                    challengeIcon.setImageResource(it.icon)
                    challengeTitleText.text = it.title
                    challengeDateText.text = "Старт через ${startAfterDays(it.startDate)} дней"
                    challengeCalendarText.text = convertChallengeDates(it.startDate, it.endDate)
                    prizeCountText.text = "${it.prizeSpacesCount} призовых мест"
                    challengeTypeText.text = it.requirements
                    challengeImage.setImageResource(it.image)
                    challengeDescText.text = it.description
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

    private fun observeSettingsState() {
        viewModel.settingsState.observe(viewLifecycleOwner) {
            binding.apply {
                nowInClubLayout.root.visibility =
                    if (it.nowInClubVisibility) View.VISIBLE else View.GONE
                challengeLayout.root.visibility =
                    if (it.newChallengeVisibility) View.VISIBLE else View.GONE
                myChallengesLayout.root.visibility =
                    if (it.userChallengesVisibility) View.VISIBLE else View.GONE
                myClubCardsLayout.root.visibility =
                    if (it.userCardsVisibility) View.VISIBLE else View.GONE
                myAccountsL.root.visibility =
                    if (it.userAccountsVisibility) View.VISIBLE else View.GONE
                myTrainingsLayout.root.visibility =
                    if (it.userTrainingsVisibility) View.VISIBLE else View.GONE
                myFriendsLayout.root.visibility =
                    if (it.userFriendsVisibility) View.VISIBLE else View.GONE
            }
        }
    }

    private fun openDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val bin =
            SettingsDialogItemBinding.bind(R.layout.settings_dialog_item.makeView(binding.root))
        viewModel.settingsState.observe(viewLifecycleOwner) {
            bin.apply {
                nowInClubSwitch.isChecked = it.nowInClubVisibility
                newChallengesSwitch.isChecked = it.newChallengeVisibility
                userChallengesSwitch.isChecked = it.userChallengesVisibility
                userCardsSwitch.isChecked = it.userCardsVisibility
                userAccountsSwitch.isChecked = it.userAccountsVisibility
                userTrainingsSwitch.isChecked = it.userTrainingsVisibility
                userFriendsSwitch.isChecked = it.userFriendsVisibility
            }
        }
        bin.apply {
            saveBtn.setOnClickListener {
                viewModel.changeStates(
                    nowInClubState = nowInClubSwitch.isChecked,
                    newChallengeState = newChallengesSwitch.isChecked,
                    userChallengesState = userChallengesSwitch.isChecked,
                    userCardsState = userCardsSwitch.isChecked,
                    userAccountsState = userAccountsSwitch.isChecked,
                    userTrainingsState = userTrainingsSwitch.isChecked,
                    userFriendsState = userFriendsSwitch.isChecked,
                )
                dialog.dismiss()
            }
            cancelBtn.setOnClickListener {
                makeToast("Изменения не сохранены")
                dialog.dismiss()
            }
        }

        dialog.setCancelable(true)
        dialog.setContentView(bin.root)
        dialog.show()
    }

}