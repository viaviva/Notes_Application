package com.example.notes.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.getDate(): String = format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))