package com.example.galladance.presentation.ui.adapters.account

import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyAccountsLayoutItemBinding
import com.example.galladance.presentation.models.AccountUi

class AccountViewHolder(val binding: MyAccountsLayoutItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(account: AccountUi) {
        var type = "₽"
        when (account.accountType) {
            "personal" -> {
                binding.accountIcon.setImageResource(R.drawable.money_icon)
                binding.accountType.text = "Лицевой"
            }
            "bonus" -> {
                binding.accountIcon.setImageResource(R.drawable.percent_icon)
                binding.accountType.text = "Бонусный"
                type = "бонусов"
            }
        }
        if (account.accountSum % 1 == 0) {
            binding.accountSumText.text =
                StringBuilder().append(account.accountSum).append(" ").append(type)
        } else {
            binding.accountSumText.text =
                StringBuilder().append(account.accountSum).append(" ").append(type)
        }
        binding.clubTitleText.text = account.fitnessClub.clubTitle
    }

}