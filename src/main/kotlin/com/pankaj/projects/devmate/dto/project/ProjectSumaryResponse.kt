package com.pankaj.projects.devmate.dto.project

import java.time.Instant

data class ProjectSumaryResponse(
    val id : Long,
    val name : String,
    val createdAt : Instant,
    val updatedAt : Instant
)
