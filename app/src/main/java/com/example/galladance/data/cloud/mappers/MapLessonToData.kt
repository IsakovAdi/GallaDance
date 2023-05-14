package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.CoachCloud
import com.example.galladance.data.cloud.models.LessonCloud
import com.example.galladance.data.models.CoachData
import com.example.galladance.data.models.LessonData
import com.example.galladance.domain.Mapper

class MapLessonToData(
    private val mapper: Mapper<CoachCloud, CoachData>,
) : Mapper<LessonCloud, LessonData> {
    override fun map(from: LessonCloud) = from.run {
        LessonData(
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