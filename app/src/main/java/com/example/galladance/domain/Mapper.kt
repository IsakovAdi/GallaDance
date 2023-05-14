package com.example.galladance.domain

interface Mapper<From, To> {
    fun map(from: From): To
}