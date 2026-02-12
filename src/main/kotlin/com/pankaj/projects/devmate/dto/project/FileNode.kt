package com.pankaj.projects.devmate.dto.project

import java.time.Instant

data class FileNode(
    val path: String,
    val modifiedAt: Instant, val size: Long,
    val type: String
)