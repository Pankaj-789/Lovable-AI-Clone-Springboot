package com.pankaj.projects.devmate.repository

import com.pankaj.projects.devmate.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}