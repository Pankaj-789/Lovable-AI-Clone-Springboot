package com.pankaj.projects.devmate.dto.subscription

data class PlanResponse (
    val id : Long,
    val name : String,
    val maxProjects : Integer,
    val maxTokensPerDay : Integer,
    val unlimitedAi : Boolean,
    val price : String
)