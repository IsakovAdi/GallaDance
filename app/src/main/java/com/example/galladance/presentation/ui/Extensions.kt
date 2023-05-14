package com.example.galladance.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun Int.makeView(parent: ViewGroup): View =
    LayoutInflater.from(parent.context).inflate(this, parent, false)

