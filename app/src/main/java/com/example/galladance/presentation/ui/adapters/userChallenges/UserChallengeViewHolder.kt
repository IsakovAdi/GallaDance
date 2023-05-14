package com.example.galladance.presentation.ui.adapters.userChallenges

import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.databinding.ChallengeLayoutBinding
import com.example.galladance.databinding.MyChallengeLayoutItemBinding
import com.example.galladance.presentation.models.ChallengeUi
import com.squareup.picasso.Picasso

class UserChallengeViewHolder(val binding: MyChallengeLayoutItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(challenge: ChallengeUi) {
        binding.myChallengeIcon.setImageResource(challenge.icon)
        binding.apply {
            challengeTitleText.text = challenge.title
            challengeEndDateText.text = "Осталось дней: ${challenge.daysLeft}"
            userPlaceInChallengeText.text = "${challenge.userSpace} место"
            userResultInChallengeText.text =
                "${challenge.userResult} из ${challenge.requirementsCount}"
        }
    }
}