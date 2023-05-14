package com.example.galladance.presentation.ui.adapters.lesson

import androidx.recyclerview.widget.DiffUtil
import com.example.galladance.presentation.models.LessonUi

class LessonDiffCallback : DiffUtil.ItemCallback<LessonUi>() {
    override fun areItemsTheSame(oldItem: LessonUi, newItem: LessonUi) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: LessonUi, newItem: LessonUi) = oldItem == newItem
}