package com.pankaj.projects.devmate.dto.auth

data class UserProfileResponse(
    val id: Long?,
    val name: String,
    val email: String,
    val avatarUrl: String
)