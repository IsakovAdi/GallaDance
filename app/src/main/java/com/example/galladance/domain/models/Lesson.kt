package com.example.galladance.domain.models

data class Lesson(
    val id: Int,
    val title: String,
    var date: String,
    val startTime: String,
    val endTime: String,
    val coach: Coach,
    val space: String,
)