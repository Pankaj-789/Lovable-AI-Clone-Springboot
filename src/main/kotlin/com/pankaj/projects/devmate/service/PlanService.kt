package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.subscription.PlanResponse

interface PlanService {

    fun getAllActivePlans() : List<PlanResponse>

}