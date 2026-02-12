package com.pankaj.projects.devmate.entity

import java.time.Instant

class ChatSession(
    var project: Project,
    var user: User,
    var title : String,
    var createdAt : Instant,
    var updatedAt : Instant,
    var deletedAt : Instant
)