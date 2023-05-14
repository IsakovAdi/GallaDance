package com.example.galladance.presentation.ui.adapters.userCard

import androidx.recyclerview.widget.DiffUtil
import com.example.galladance.presentation.models.ClubCardUi

class ClubCardDiffCallback(
    private val newList: List<ClubCardUi>,
    private val oldList: List<ClubCardUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}