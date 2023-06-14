package com.example.notes.validation

import com.example.notes.R

fun titleValidation(title: String): ValidationResult {
    return if (title != "") {
        when {
            title[0].isUpperCase() -> ValidationResult.Valid
            else -> ValidationResult.Invalid(R.string.title_invalid)
        }
    } else ValidationResult.Invalid(R.string.title_invalid)
}