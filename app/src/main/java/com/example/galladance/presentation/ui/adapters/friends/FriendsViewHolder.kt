package com.example.galladance.presentation.ui.adapters.friends

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.databinding.MyFriendsItemBinding
import com.example.galladance.presentation.models.ClubUserUi
import com.squareup.picasso.Picasso

class FriendsViewHolder(val binding: MyFriendsItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: ClubUserUi, position:Int) {
        Picasso.get().load(user.image).into(binding.friendsImage)
        if (user.isInClub) binding.isOnlineIcon.visibility = View.VISIBLE
        if (position == 0){
            val params = binding.root.layoutParams as ViewGroup.MarginLayoutParams
            params.marginStart = 0
            binding.root.layoutParams = params
        }
    }
}