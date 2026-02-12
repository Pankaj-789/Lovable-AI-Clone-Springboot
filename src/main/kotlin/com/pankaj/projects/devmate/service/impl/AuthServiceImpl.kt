package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.auth.AuthResponse
import com.pankaj.projects.devmate.dto.auth.LoginRequest
import com.pankaj.projects.devmate.dto.auth.SignUpRequest
import com.pankaj.projects.devmate.service.AuthService
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {
    override fun signup(request: SignUpRequest): AuthResponse {
        TODO("Not yet implemented")
    }

    override fun login(request: LoginRequest): AuthResponse {
        TODO("Not yet implemented")
    }

}