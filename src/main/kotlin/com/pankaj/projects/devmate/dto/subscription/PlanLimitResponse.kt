package com.pankaj.projects.devmate.dto.subscription

data class PlanLimitResponse(
    val planName : String,
    val maxTokensPerDay : Int,
    val maxProjects : Int,
    val unlimitedAi : Boolean
)
