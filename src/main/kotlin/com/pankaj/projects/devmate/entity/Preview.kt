package com.pankaj.projects.devmate.entity

import com.pankaj.projects.devmate.enums.PreviewStatus
import java.time.Instant

class Preview(
    var id: Long,
    var project: Project,
    var namespace: String,
    var podName: String,
    var previewUrl: String,
    var status: PreviewStatus,
    var startedAt: Instant,
    var terminatedAt: Instant,
    var createdAt: Instant
) {
}