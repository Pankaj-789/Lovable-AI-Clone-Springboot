package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.auth.UserProfileResponse
import com.pankaj.projects.devmate.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    override fun getProfile(userId: Long): UserProfileResponse {
        TODO("Not yet implemented")
    }
}