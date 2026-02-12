package com.pankaj.projects.devmate.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import java.io.Serializable

@Embeddable
 class ProjectMemberId(
    var projectId : Long,
    var userId : Long
) : Serializable
//@Embeddable
//class ProjectMemberId() : Serializable {
//
//    var projectId: Long? = null
//    var userId: Long? = null
//
//    constructor(projectId: Long, userId: Long) : this() {
//        this.projectId = projectId
//        this.userId = userId
//    }
//}