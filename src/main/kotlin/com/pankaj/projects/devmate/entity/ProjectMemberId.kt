package com.pankaj.projects.devmate.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import java.io.Serializable

@Embeddable
 class ProjectMemberId(
    var projectId : Long,
    var userId : Long
) : Serializable
