package com.pankaj.projects.devmate.repository

import com.pankaj.projects.devmate.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : JpaRepository<Project,Long>{

    @Query("""
        SELECT p from Project p
        WHERE p.deletedAt IS NULL
        AND p.owner.id = :userId
        ORDER BY p.updatedAt DESC
        """)
    fun findAllAccessibleByUser(@Param("userId") userId : Long) : List<Project>

    @Query("""
        SELECT p from Project p
        LEFT JOIN FETCH p.owner
        WHERE p.id = :projectId
        AND p.deletedAt IS NULL
        AND p.owner.id = :userId
        """)
    fun findAccessibleProjectById(@Param("projectId") projectId : Long,
                                  @Param("userId") userId : Long) : Project


}


