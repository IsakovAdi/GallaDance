package com.example.galladance.presentation.models

class LessonUi(
    val id: Int,
    val title: String,
    var date: String,
    val startTime: String,
    val endTime: String,
    val coach: CoachUi,
    val space: String,
)