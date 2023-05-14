package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.LessonCloud
import com.example.galladance.data.models.LessonData
import com.example.galladance.domain.Mapper

class MapLessonListToData(
    private val mapper: Mapper<LessonCloud, LessonData>,
) : Mapper<List<LessonCloud>, List<LessonData>> {
    override fun map(from: List<LessonCloud>) = from.run {
        map(mapper::map)
    }
}