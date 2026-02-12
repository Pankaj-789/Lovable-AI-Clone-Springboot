package com.pankaj.projects.devmate.dto.subscription

import com.pankaj.projects.devmate.entity.Plan
import java.time.Instant

data class SubscriptionResponse(
    val plan : PlanResponse,
    val status : String,
    val periodEnd : Instant,
    val tokensUsedThisCycle : Long

)
