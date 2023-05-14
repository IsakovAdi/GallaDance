package com.example.galladance.data.cloud.models


class LessonCloud(
    val id: Int,
    val title: String,
    var date: String,
    val startTime: String,
    val endTime: String,
    val coach: CoachCloud,
    val space: String,
)