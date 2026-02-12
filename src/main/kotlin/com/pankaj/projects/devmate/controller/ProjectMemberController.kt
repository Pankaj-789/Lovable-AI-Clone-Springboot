package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.member.InviteMemberRequest
import com.pankaj.projects.devmate.dto.member.MemberResponse
import com.pankaj.projects.devmate.entity.ProjectMember
import com.pankaj.projects.devmate.service.ProjectMemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/projects/{projectId}/members")
class ProjectMemberController(private val projectMemberService: ProjectMemberService) {

    @GetMapping
    fun getProjectMembers(@PathVariable projectId : Long) : ResponseEntity<List<ProjectMember>>{
        val userId = 1L
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId))
    }

    @PostMapping
    fun inviteMember(@PathVariable projectId : Long,@RequestBody request : InviteMemberRequest) : ResponseEntity<MemberResponse>{
        val userId = 1L
        return ResponseEntity.status(HttpStatus.CREATED).body(
            projectMemberService.inviteMember(projectId , request, userId)
        )
    }

    @PatchMapping("/{memberId}")
    fun updateMemberRole(@PathVariable projectId : Long,
                         @PathVariable memberId : Long,
                         @RequestBody request : InviteMemberRequest) : ResponseEntity<MemberResponse>{
        val userId = 1L
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request,userId))

    }

    @DeleteMapping("/{memberId}")
    fun deleteProjectMember(@PathVariable projectId : Long,
                         @PathVariable memberId : Long) : ResponseEntity<MemberResponse>{
        val userId = 1L
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId,memberId,userId))

    }





}