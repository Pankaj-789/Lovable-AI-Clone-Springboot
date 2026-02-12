package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.auth.UserProfileResponse

interface UserService {

    fun getProfile(userId : Long) : UserProfileResponse
}