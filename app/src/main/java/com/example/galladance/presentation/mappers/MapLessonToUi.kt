package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Coach
import com.example.galladance.domain.models.Lesson
import com.example.galladance.presentation.models.CoachUi
import com.example.galladance.presentation.models.LessonUi

class MapLessonToUi(
    private val mapper: Mapper<Coach, CoachUi>,
) : Mapper<Lesson, LessonUi> {
    override fun map(from: Lesson) = from.run {
        LessonUi(
            id = id,
            title = title,
            date = date,
            startTime = startTime,
            endTime = endTime,
            coach = mapper.map(coach),
            space = space,
        )
    }
}