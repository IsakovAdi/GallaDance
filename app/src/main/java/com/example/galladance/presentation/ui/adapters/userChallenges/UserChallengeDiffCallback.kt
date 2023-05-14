package com.example.galladance.presentation.ui.adapters.userChallenges

import androidx.recyclerview.widget.DiffUtil
import com.example.galladance.presentation.models.ChallengeUi

class UserChallengeDiffCallback(
    private val newList: List<ChallengeUi>,
    private val oldList: List<ChallengeUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[oldItemPosition]


}