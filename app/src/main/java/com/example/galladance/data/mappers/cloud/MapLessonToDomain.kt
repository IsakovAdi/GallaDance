package com.example.galladance.data.mappers.cloud

import com.example.galladance.data.models.CoachData
import com.example.galladance.data.models.LessonData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Coach
import com.example.galladance.domain.models.Lesson

class MapLessonToDomain(
    private val mapper: Mapper<CoachData, Coach>,
) : Mapper<LessonData, Lesson> {
    override fun map(from: LessonData) = from.run {
        Lesson(
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