package com.pankaj.projects.devmate.entity

import com.pankaj.projects.devmate.enums.ProjectRole
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import java.time.Instant


@Entity
@Table(name = "project_members")
class ProjectMember(
    @EmbeddedId
    var id: ProjectMemberId,

    @ManyToOne
    @MapsId("projectId")
    var project: Project,

    @ManyToOne
    @MapsId("userId")
    var user: User,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var projectRole: ProjectRole,

    var invitedAt : Instant? = null,
    var acceptedAt : Instant? = null
)