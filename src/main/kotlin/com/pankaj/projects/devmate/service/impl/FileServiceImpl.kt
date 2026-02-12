package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.project.FileContentResponse
import com.pankaj.projects.devmate.dto.project.FileNode
import com.pankaj.projects.devmate.service.FileService
import org.springframework.stereotype.Service

@Service
class FileServiceImpl : FileService {

    override fun getFileTree(projectId: Long, userId: Long): List<FileNode>? {
        TODO("Not yet implemented")
    }

    override fun getFileContent(projectId: Long, path: String, userId: Long): FileContentResponse? {
        TODO("Not yet implemented")
    }
}