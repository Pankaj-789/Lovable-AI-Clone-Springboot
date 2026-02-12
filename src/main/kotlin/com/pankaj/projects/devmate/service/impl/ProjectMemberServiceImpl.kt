package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.member.InviteMemberRequest
import com.pankaj.projects.devmate.dto.member.MemberResponse
import com.pankaj.projects.devmate.entity.Project
import com.pankaj.projects.devmate.entity.ProjectMember
import com.pankaj.projects.devmate.repository.ProjectMemberRepository
import com.pankaj.projects.devmate.repository.ProjectRepository
import com.pankaj.projects.devmate.service.ProjectMemberService
import org.springframework.stereotype.Service

@Service
class ProjectMemberServiceImpl(
    private val projectMemberRepository: ProjectMemberRepository,
    private val projectRepository: ProjectRepository) : ProjectMemberService {
    override fun getProjectMembers(projectId: Long, userId: Long): List<ProjectMember>? {
//       val project : Project = getAccessibleProjectById(projectId,userId)
//        val memberResponseList : List<MemberResponse> = arrayListOf()
//        memberResponseList.add(project.get)
//        return
        TODO()

    }

    override fun inviteMember(projectId: Long, request: InviteMemberRequest, userId: Long): MemberResponse? {
        TODO("Not yet implemented")
    }

    override fun updateMemberRole(
        projectId: Long,
        memberId: Long,
        request: InviteMemberRequest,
        userId: Long
    ): MemberResponse? {
        TODO("Not yet implemented")
    }

    override fun deleteProjectMember(projectId: Long, memberId: Long, userId: Long): MemberResponse? {
        TODO("Not yet implemented")
    }

    fun getAccessibleProjectById(projectId: Long, userId: Long): Project {
        return projectRepository.findAccessibleProjectById(projectId, userId)
    }
}