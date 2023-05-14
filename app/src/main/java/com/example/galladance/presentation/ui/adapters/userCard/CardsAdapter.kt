package com.example.galladance.presentation.ui.adapters.userCard

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyClubCardsLayoutItemBinding
import com.example.galladance.presentation.models.ClubCardUi
import com.example.galladance.presentation.ui.makeView

class CardsAdapter : RecyclerView.Adapter<ClubCardViewHolder>() {
    var cards = emptyList<ClubCardUi>()
        set(value) {
            val callback = ClubCardDiffCallback(cards, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClubCardViewHolder(
        MyClubCardsLayoutItemBinding.bind(R.layout.my_club_cards_layout_item.makeView(parent)),
        parent
    )

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: ClubCardViewHolder, position: Int) =
        holder.bind(cards[position])
}