package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.project.ProjectRequest
import com.pankaj.projects.devmate.dto.project.ProjectResponse
import com.pankaj.projects.devmate.dto.project.ProjectSumaryResponse

interface ProjectService {
    fun getUserProjects(userId: Long): List<ProjectSumaryResponse>?
    fun getUserProjectById(id : Long, userId: Long): ProjectResponse?

    fun createProject(request: ProjectRequest, userId: Long): ProjectResponse?
    fun updateProject(id: Long, request: ProjectRequest, userId: Long): ProjectResponse?
    fun softDelete(id: Long, userId: Long)


}