package com.example.galladance.presentation.ui.adapters.lesson

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galladance.R
import com.example.galladance.databinding.MyTrainingsLayoutItemBinding
import com.example.galladance.presentation.models.LessonUi
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class LessonViewHolder(
    private val binding: MyTrainingsLayoutItemBinding,
    private val parent: ViewGroup,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(lesson: LessonUi) {
        Picasso.get().load(lesson.coach.image).into(binding.coachImage)

        binding.apply {
            trainingTitle.text = lesson.title
            trainingDateText.text =
                buildLessonDateText(lesson.date, lesson.startTime, lesson.endTime)
            coachNameText.text = lesson.coach.name
            trainingSpaceText.text = lesson.space
        }
    }

    private fun buildLessonDateText(date: String, startTime: String, endTime: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(date, formatter)
        val currentDate = LocalDate.now()
        var returnDate = ""
        returnDate = if (date == currentDate) parent.resources.getString(R.string.today_text)
        else date.format(DateTimeFormatter.ofPattern("dd MMM", Locale("RU")))

        return StringBuilder()
            .append(returnDate)
            .append("  ")
            .append(parent.resources.getString(R.string.center_dot))
            .append("  $startTime - $endTime")
            .append("  ")
            .append(parent.resources.getString(R.string.center_dot))
            .append("  ")
            .toString()
    }
}