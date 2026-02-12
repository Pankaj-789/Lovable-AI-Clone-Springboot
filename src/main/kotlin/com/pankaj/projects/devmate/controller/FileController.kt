package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.project.FileContentResponse
import com.pankaj.projects.devmate.dto.project.FileNode
import com.pankaj.projects.devmate.service.FileService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/projects/{projectsId}/files")
class FileController(private val fileService: FileService) {

    @GetMapping
    fun getFileTree(@PathVariable projectId: Long): ResponseEntity<List<FileNode>> {
        val userId: Long = 1L
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId))
    }

    @GetMapping("/{*path}")
    fun getFile(@PathVariable projectId: Long, @PathVariable path: String): ResponseEntity<FileContentResponse> {
        val userId = 1L
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId))
    }

}