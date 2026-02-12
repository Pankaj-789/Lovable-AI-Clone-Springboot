package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.project.ProjectRequest
import com.pankaj.projects.devmate.dto.project.ProjectResponse
import com.pankaj.projects.devmate.dto.project.ProjectSumaryResponse
import com.pankaj.projects.devmate.entity.Project
import com.pankaj.projects.devmate.entity.User
import com.pankaj.projects.devmate.mapper.toProjectResponse
import com.pankaj.projects.devmate.mapper.toProjectSummaryResponse
import com.pankaj.projects.devmate.repository.ProjectRepository
import com.pankaj.projects.devmate.repository.UserRepository
import com.pankaj.projects.devmate.service.ProjectService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.Instant

@Service
@Transactional
class ProjectServiceImpl(private val projectRepository: ProjectRepository,
                         private val userRepository: UserRepository) : ProjectService {

    override fun createProject(request: ProjectRequest, userId: Long): ProjectResponse? {
        val owner = userRepository.findById(userId).orElseThrow()
        val project = Project(
            name = request.name, public = false, owner = owner
        )
        val savedProject = projectRepository.save(project)
        return savedProject.toProjectResponse()
    }

    override fun getUserProjects(userId: Long): List<ProjectSumaryResponse>? {
        val projectList = projectRepository.findAllAccessibleByUser(userId)
        return projectList.map {
            it.toProjectSummaryResponse()
        }
    }

    override fun getUserProjectById(id: Long, userId: Long): ProjectResponse? {
        val projectById = projectRepository.findAccessibleProjectById(id, userId)
        return projectById.toProjectResponse()
    }

    override fun updateProject(id: Long, request: ProjectRequest, userId: Long): ProjectResponse? {
        val project = getAccessibleProjectById(id, userId)
        if (project.owner.id != userId) {
            throw RuntimeException("You are not allowed to update the name")
        }
        project.name = request.name
        return projectRepository.save(project).toProjectResponse()
    }

    override fun softDelete(id: Long, userId: Long) {
        val project = getAccessibleProjectById(id, userId)
        if (project.owner.id != userId) {
            throw RuntimeException("You are not allowed to delete")
        }
        project.deletedAt = Instant.now()
        projectRepository.save(project)
    }

    fun getAccessibleProjectById(projectId: Long, userId: Long): Project {
        return projectRepository.findAccessibleProjectById(projectId, userId)
    }
}