package com.example.notes.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.getDate(): String = format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))