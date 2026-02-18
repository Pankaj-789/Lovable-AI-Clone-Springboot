package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.member.InviteMemberRequest
import com.pankaj.projects.devmate.dto.member.MemberResponse
import com.pankaj.projects.devmate.entity.Project
import com.pankaj.projects.devmate.entity.ProjectMember
import com.pankaj.projects.devmate.entity.ProjectMemberId
import com.pankaj.projects.devmate.mapper.ProjectMemberMapper
import com.pankaj.projects.devmate.repository.ProjectMemberRepository
import com.pankaj.projects.devmate.repository.ProjectRepository
import com.pankaj.projects.devmate.repository.UserRepository
import com.pankaj.projects.devmate.service.ProjectMemberService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.Instant

@Transactional
@Service
class ProjectMemberServiceImpl(
    private val projectMemberRepository: ProjectMemberRepository,
    private val projectRepository: ProjectRepository,
    private val projectMemberMapper: ProjectMemberMapper,
    private val userRepository: UserRepository
) : ProjectMemberService {
    override fun getProjectMembers(projectId: Long, userId: Long): List<MemberResponse> {

        val project = getAccessibleProjectById(projectId, userId)

        val members = projectMemberRepository
            .findByIdProjectId(projectId)
//            .filter { it.user.id != project.owner.id }   // prevent duplicate owner
            .map(projectMemberMapper::toProjectMemberResponseFromMember)

        val ownerResponse =
            projectMemberMapper.toProjectMemberResponseFromOwner(project.owner)

        return listOf(ownerResponse) + members

    }

    override fun inviteMember(projectId: Long, request: InviteMemberRequest, userId: Long): MemberResponse? {
        val project = getAccessibleProjectById(projectId, userId)

//        check for the owner
        if (project.owner.id != userId) {
            throw RuntimeException("Only owner can invite members")

        }
//       invitee :  a person who receives an invitation
        val invitee = userRepository.findByEmail(request.email)

//      Prevent owner from inviting himself
        if (invitee.id == userId) {
            throw RuntimeException("Owner cannot invite himself")

        }
//        fetch project member Id
        val projectMemberId = ProjectMemberId(projectId, invitee.id!!)

//        check if the user is already invited
        if (projectMemberRepository.existsById(projectMemberId)) {
            throw RuntimeException("User already invited to this project")
        }

        val member = ProjectMember(
            id = projectMemberId,
            project = project,
            user = invitee,
            projectRole = request.role,
            invitedAt = Instant.now(),
            acceptedAt = null
        )

        // Save entity in DB
        val savedMember = projectMemberRepository.save(member)
        return projectMemberMapper.toProjectMemberResponseFromMember(savedMember)

    }

    override fun updateMemberRole(
        projectId: Long,
        memberId: Long,
        request: InviteMemberRequest,
        userId: Long
    ): MemberResponse? {
        val project = getAccessibleProjectById(projectId, userId)

//        check for the owner
        if (project.owner.id != userId) {
            throw RuntimeException("Only owner can invite members")
        }
        val projectMemberId = ProjectMemberId(projectId, memberId)
        val projectMember: ProjectMember = projectMemberRepository.findById(projectMemberId).orElseThrow()

        projectMember.projectRole = request.role
        projectMemberRepository.save(projectMember)
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember)
    }

    override fun removeProjectMember(projectId: Long, memberId: Long, userId: Long) {
        val project = getAccessibleProjectById(projectId, userId)

//        check for the owner
        if (project.owner.id != userId) {
            throw RuntimeException("Not Allowed!! Only owner can invite members")
        }
        val projectMemberId = ProjectMemberId(projectId, memberId)

        // check if the project member exist
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw RuntimeException("Member not found in project")
        }
        projectMemberRepository.deleteById(projectMemberId)
    }

    fun getAccessibleProjectById(projectId: Long, userId: Long): Project {
        return projectRepository.findAccessibleProjectById(projectId, userId)
    }
}