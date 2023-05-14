package com.example.galladance.data.mappers

import com.example.galladance.data.models.LessonData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Lesson

class MapLessonListToDomain(
    private val mapper: Mapper<LessonData, Lesson>,
) : Mapper<List<LessonData>, List<Lesson>> {
    override fun map(from: List<LessonData>) = from.run {
        map(mapper::map)
    }
}