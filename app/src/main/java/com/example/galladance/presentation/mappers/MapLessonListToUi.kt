package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Lesson
import com.example.galladance.presentation.models.LessonUi

class MapLessonListToUi(
    private val mapper: Mapper<Lesson, LessonUi>,
) : Mapper<List<Lesson>, List<LessonUi>> {
    override fun map(from: List<Lesson>) = from.run {
        map(mapper::map)
    }
}