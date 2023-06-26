package com.example.notes.validation

sealed class ValidationResult {

    object Valid : ValidationResult()
    class Invalid(val errorId: Int) : ValidationResult()

}