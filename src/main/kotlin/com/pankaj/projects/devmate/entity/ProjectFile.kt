package com.pankaj.projects.devmate.entity

import java.time.Instant

class ProjectFile(
    var id: Long,
    var project: Project,
    var path: String,
    var minioObjectKey: String,
    var createdAt: Instant,
    var updatedAt: Instant,
    var createdBy: User,
    var updatedBy: User
)
