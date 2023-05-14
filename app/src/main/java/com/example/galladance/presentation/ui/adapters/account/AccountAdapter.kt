package com.example.galladance.presentation.ui.adapters.account

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyAccountsLayoutItemBinding
import com.example.galladance.presentation.models.AccountUi
import com.example.galladance.presentation.ui.makeView

class AccountAdapter : RecyclerView.Adapter<AccountViewHolder>() {
    var accounts = listOf<AccountUi>()
        set(value) {
            val callback = AccountDiffCallback(accounts, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AccountViewHolder(
            MyAccountsLayoutItemBinding.bind(R.layout.my_accounts_layout_item.makeView(parent))
        )

    override fun getItemCount() = accounts.size

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accounts[position])
    }
}