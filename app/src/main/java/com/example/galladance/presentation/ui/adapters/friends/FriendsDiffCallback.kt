package com.example.galladance.presentation.ui.adapters.friends

import androidx.recyclerview.widget.DiffUtil
import com.example.galladance.presentation.models.ClubUserUi

class FriendsDiffCallback(
    private val newList: List<ClubUserUi>,
    private val oldList: List<ClubUserUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

}