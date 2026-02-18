package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.member.InviteMemberRequest
import com.pankaj.projects.devmate.dto.member.MemberResponse

interface ProjectMemberService {
    fun getProjectMembers(projectId: Long, userId: Long): List<MemberResponse>?
    fun inviteMember(projectId: Long, request: InviteMemberRequest, userId: Long): MemberResponse?
    fun updateMemberRole(projectId: Long, memberId: Long, request: InviteMemberRequest, userId: Long): MemberResponse?
    fun removeProjectMember(projectId: Long, memberId: Long, userId: Long)


}

