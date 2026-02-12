package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.auth.AuthResponse
import com.pankaj.projects.devmate.dto.auth.LoginRequest
import com.pankaj.projects.devmate.dto.auth.SignUpRequest
import com.pankaj.projects.devmate.dto.auth.UserProfileResponse
import com.pankaj.projects.devmate.service.AuthService
import com.pankaj.projects.devmate.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController (private val authService: AuthService, private val userService: UserService){

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest) : ResponseEntity<AuthResponse>{
        return ResponseEntity.ok(authService.signup(request))
    }

    @PostMapping("/login")
    fun login(@RequestBody request : LoginRequest) : ResponseEntity<AuthResponse>{
        return ResponseEntity.ok(authService.login(request))
    }

    @GetMapping("/me")
    fun getProfile() : ResponseEntity<UserProfileResponse>{
        val userId = 1L
        return ResponseEntity.ok(userService.getProfile(userId))
    }
}
