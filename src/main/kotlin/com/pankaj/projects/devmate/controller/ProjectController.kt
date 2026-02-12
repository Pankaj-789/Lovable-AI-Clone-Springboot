package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.project.ProjectRequest
import com.pankaj.projects.devmate.dto.project.ProjectResponse
import com.pankaj.projects.devmate.dto.project.ProjectSumaryResponse
import com.pankaj.projects.devmate.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/projects")
class ProjectController(private val projectService: ProjectService) {

    @GetMapping
    fun getMyProjects() : ResponseEntity<List<ProjectSumaryResponse>>{
        val userId = 1L
        return ResponseEntity.ok(projectService.getUserProjects(userId))

    }

    @GetMapping("/{id}")
    fun getProjectById(@PathVariable id : Long) : ResponseEntity<ProjectResponse>{
        val userId = 1L
        return ResponseEntity.ok(projectService.getUserProjectById(id,userId)) //project id, user id
    }

    @PostMapping
    fun createProject(@RequestBody request : ProjectRequest) : ResponseEntity<ProjectResponse> {
        val userId = 1L
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request, userId))

    }
    @PatchMapping("/{id}")
    fun updateProject(@PathVariable id : Long, @RequestBody request: ProjectRequest) : ResponseEntity<ProjectResponse>{
        val userId = 1L
        return ResponseEntity.ok(projectService.updateProject(id, request, userId))
    }

    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable id : Long) : ResponseEntity<Void>{
        val userId = 1L
        projectService.softDelete(id, userId)
        return ResponseEntity.noContent().build()
    }

}