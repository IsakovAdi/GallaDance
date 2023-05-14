package com.example.galladance.domain.models

data class Account(
    val accountId:Int,
    val accountType:String,
    val accountSum:Int,
    val fitnessClub: FitnessClub
)