package com.example.galladance.presentation.ui.adapters.lesson

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.galladance.R
import com.example.galladance.databinding.MyTrainingsLayoutItemBinding
import com.example.galladance.presentation.models.LessonUi
import com.example.galladance.presentation.ui.makeView

class LessonAdapter : ListAdapter<LessonUi, LessonViewHolder>(LessonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LessonViewHolder(
        MyTrainingsLayoutItemBinding.bind(R.layout.my_trainings_layout_item.makeView(parent)),
        parent
    )

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) =
        holder.bind(getItem(position))
}