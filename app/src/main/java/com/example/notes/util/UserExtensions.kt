package com.example.notes.util

import com.example.notes.entity.UserEntity
import com.example.notes.model.User

fun User.toUserEntity() = UserEntity(
    firstName,
    lastName,
    email,
    password
)