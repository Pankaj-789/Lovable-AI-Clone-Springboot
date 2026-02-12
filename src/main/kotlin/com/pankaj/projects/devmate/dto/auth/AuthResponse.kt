package com.pankaj.projects.devmate.dto.auth

data class AuthResponse(
    val token : String,
    val user : UserProfileResponse

)
