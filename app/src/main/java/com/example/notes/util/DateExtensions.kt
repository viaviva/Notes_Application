package com.example.notes.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun longToDate(date: Long): String =
    LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

