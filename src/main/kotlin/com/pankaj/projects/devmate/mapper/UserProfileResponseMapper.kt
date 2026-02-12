package com.pankaj.projects.devmate.mapper

import com.pankaj.projects.devmate.dto.auth.UserProfileResponse
import com.pankaj.projects.devmate.entity.User


fun User.toUserProfileResponse(): UserProfileResponse =
    UserProfileResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        avatarUrl = this.avatarUrl ?: ""
    )
