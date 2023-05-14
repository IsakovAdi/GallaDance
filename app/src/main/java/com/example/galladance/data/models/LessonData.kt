package com.example.galladance.data.models


class LessonData(
    val id: Int,
    val title: String,
    var date: String,
    val startTime: String,
    val endTime: String,
    val coach: CoachData,
    val space: String,
)