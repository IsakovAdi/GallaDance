package com.example.galladance.presentation.ui.adapters.nowInClub

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.NowInClubItemBinding
import com.example.galladance.presentation.models.ClubUserUi
import com.example.galladance.presentation.ui.makeView

class NowInClubAdapter : RecyclerView.Adapter<NowInClubViewHolder>() {
    var users = emptyList<ClubUserUi>()
        set(value) {
            val callback = NowInClubDiffCallback(users, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NowInClubViewHolder(
        NowInClubItemBinding.bind(R.layout.now_in_club_item.makeView(parent))
    )

    override fun getItemCount() = if (users.size > limit) limit else users.size

    override fun onBindViewHolder(holder: NowInClubViewHolder, position: Int) =
        holder.bind(users[position], position)

    companion object {
        private const val limit = 3
    }
}