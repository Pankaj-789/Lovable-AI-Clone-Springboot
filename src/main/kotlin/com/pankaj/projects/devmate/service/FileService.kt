package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.project.FileContentResponse
import com.pankaj.projects.devmate.dto.project.FileNode

interface FileService {
    fun getFileTree(projectId: Long, userId: Long): List<FileNode>?
    fun getFileContent(projectId: Long, path: String, userId: Long): FileContentResponse?
}
