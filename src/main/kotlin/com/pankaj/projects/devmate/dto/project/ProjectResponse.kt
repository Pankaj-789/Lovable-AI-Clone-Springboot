package com.pankaj.projects.devmate.dto.project

import com.pankaj.projects.devmate.dto.auth.UserProfileResponse
import java.time.Instant

data class ProjectResponse(
    val id : Long,
    val name : String,
    val createdAt : Instant,
    val updatedAt : Instant,
    val owner : UserProfileResponse
)
