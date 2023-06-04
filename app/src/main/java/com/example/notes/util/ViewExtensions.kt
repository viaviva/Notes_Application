package com.example.notes.util

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.getText(): String = editText?.text?.toString() ?: ""