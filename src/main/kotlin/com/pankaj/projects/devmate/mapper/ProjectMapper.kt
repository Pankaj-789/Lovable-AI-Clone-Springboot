package com.pankaj.projects.devmate.mapper

import com.pankaj.projects.devmate.dto.auth.UserProfileResponse
import com.pankaj.projects.devmate.dto.project.ProjectResponse
import com.pankaj.projects.devmate.dto.project.ProjectSumaryResponse
import com.pankaj.projects.devmate.entity.Project
import com.pankaj.projects.devmate.entity.User
import org.springframework.stereotype.Component

/**
 * Maps Project Entity to ProjectResponse DTO
 * Safe, readable, and idiomatic Kotlin
 */
/**
 * Maps Project entity to ProjectResponse DTO
 */
fun Project.toProjectResponse(): ProjectResponse =
    ProjectResponse(
        id = this.id,
        name = this.name,
        createdAt = requireNotNull(this.createdAt),
        updatedAt = requireNotNull(this.updatedAt),
        owner = this.owner.toUserProfileResponse()
    )


fun Project.toProjectSummaryResponse(): ProjectSumaryResponse =
    ProjectSumaryResponse(
        this.id,
        this.name,
        this.createdAt!!,
        this.updatedAt!!
    )

