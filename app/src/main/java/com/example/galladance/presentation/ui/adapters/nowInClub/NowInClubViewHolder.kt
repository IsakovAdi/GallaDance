package com.example.galladance.presentation.ui.adapters.nowInClub

import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.databinding.NowInClubItemBinding
import com.example.galladance.presentation.models.ClubUserUi
import com.squareup.picasso.Picasso

class NowInClubViewHolder(val binding: NowInClubItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: ClubUserUi, pos: Int) {
        Picasso.get().load(user.image).into(binding.nowInClubPersons)
        if (pos == 0) {
            val params = binding.root.layoutParams as ViewGroup.MarginLayoutParams
            params.marginStart = 0
            binding.root.layoutParams = params
        }
    }

}