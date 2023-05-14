package com.example.galladance.presentation.ui.adapters.friends

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyFriendsItemBinding
import com.example.galladance.presentation.models.ClubUserUi
import com.example.galladance.presentation.ui.makeView


class FriendsAdapter : RecyclerView.Adapter<FriendsViewHolder>() {
    var users = emptyList<ClubUserUi>()
        set(value) {
            val callback = FriendsDiffCallback(users, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FriendsViewHolder(
        MyFriendsItemBinding.bind(R.layout.my_friends_item.makeView(parent = parent))
    )

    override fun getItemCount(): Int {
        return if (users.size > limit) limit else users.size
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) =
        holder.bind(users[position], position)

    companion object {
        const val limit = 5
    }
}