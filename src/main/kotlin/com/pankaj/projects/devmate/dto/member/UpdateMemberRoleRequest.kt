package com.pankaj.projects.devmate.dto.member

import com.pankaj.projects.devmate.enums.ProjectRole

data class UpdateMemberRoleRequest(
    val role : ProjectRole
)
