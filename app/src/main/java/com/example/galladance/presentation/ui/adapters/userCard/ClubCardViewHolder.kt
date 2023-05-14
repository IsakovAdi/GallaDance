package com.example.galladance.presentation.ui.adapters.userCard

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyClubCardsLayoutItemBinding
import com.example.galladance.presentation.models.ClubCardUi

class ClubCardViewHolder(val binding: MyClubCardsLayoutItemBinding, val p: ViewGroup) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(card: ClubCardUi) {
        when (card.isActive) {
            true -> {
                binding.cardStatusBackground.setBackgroundColor(p.resources.getColor(R.color.card_status_active_color))
                binding.isActiveText.text = "Активна"
            }
            else -> {
                binding.cardStatusBackground.setBackgroundColor(p.resources.getColor(R.color.card_status_inactive_color))
                binding.isActiveText.text = "Заморожена"
            }

        }
        binding.fitnessClubTitle.text = card.fitnessClub.clubTitle
        binding.cardType.text = card.cardType
        binding.cardValidText.text = "До ${card.activeDate} (${card.visitCount})"
        binding.lessonsLeftText.text = "Осталось ${card.visitsLeft} посещений"
        binding.fitnessClubIcon.setImageResource(card.fitnessClub.clubLogo)
        binding.cardQr.setImageResource(card.qr)
//        Picasso.get().load(card.fitnessClub.clubLogo).into(binding.fitnessClubIcon)
//        Picasso.get().load(card.qr).into(binding.cardQr)
    }
}