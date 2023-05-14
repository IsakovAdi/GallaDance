package com.example.galladance.presentation.ui.adapters.userChallenges

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyChallengeLayoutItemBinding
import com.example.galladance.presentation.models.ChallengeUi
import com.example.galladance.presentation.ui.makeView

class UserChallengesAdapter : RecyclerView.Adapter<UserChallengeViewHolder>() {
    var challenges = emptyList<ChallengeUi>()
        set(value) {
            val callback = UserChallengeDiffCallback(challenges, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserChallengeViewHolder(
        MyChallengeLayoutItemBinding.bind(R.layout.my_challenge_layout_item.makeView(parent))
    )

    override fun getItemCount() = challenges.size

    override fun onBindViewHolder(holder: UserChallengeViewHolder, position: Int) =
        holder.bind(challenges[position])
}