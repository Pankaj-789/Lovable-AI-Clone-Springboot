package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.member.InviteMemberRequest
import com.pankaj.projects.devmate.dto.member.MemberResponse
import com.pankaj.projects.devmate.entity.ProjectMember

interface ProjectMemberService {
    fun getProjectMembers(projectId: Long, userId: Long): List<ProjectMember>?
    fun inviteMember(projectId: Long, request: InviteMemberRequest, userId: Long): MemberResponse?
    fun updateMemberRole(projectId: Long, memberId: Long, request: InviteMemberRequest, userId: Long): MemberResponse?
    fun deleteProjectMember(projectId: Long, memberId: Long, userId: Long): MemberResponse?


}

