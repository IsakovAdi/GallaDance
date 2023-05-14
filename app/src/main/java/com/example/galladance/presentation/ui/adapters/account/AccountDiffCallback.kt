package com.example.galladance.presentation.ui.adapters.account

import androidx.recyclerview.widget.DiffUtil
import com.example.galladance.data.cloud.models.AccountCloud
import com.example.galladance.presentation.models.AccountUi

class AccountDiffCallback(
    private val newList: List<AccountUi>,
    private val oldList: List<AccountUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].accountId == newList[newItemPosition].accountId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}