package com.pankaj.projects.devmate.repository

import com.pankaj.projects.devmate.entity.ProjectMember
import com.pankaj.projects.devmate.entity.ProjectMemberId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectMemberRepository : JpaRepository<ProjectMember, ProjectMemberId> {
}