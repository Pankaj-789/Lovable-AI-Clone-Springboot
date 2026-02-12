package com.pankaj.projects.devmate.dto.member

import com.pankaj.projects.devmate.enums.ProjectRole
import java.time.Instant

data class MemberResponse(
    val userId : Long,
    val email : String,
    val name : String,
    val avatarUrl : String,
    val role : ProjectRole,
    val invitedAt : Instant
)