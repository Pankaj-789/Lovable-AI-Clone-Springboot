package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.auth.AuthResponse
import com.pankaj.projects.devmate.dto.auth.LoginRequest
import com.pankaj.projects.devmate.dto.auth.SignUpRequest

interface AuthService {

    fun signup(request: SignUpRequest) : AuthResponse

    fun login(request: LoginRequest) : AuthResponse
}