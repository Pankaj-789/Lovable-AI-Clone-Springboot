package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.subscription.PlanLimitResponse
import com.pankaj.projects.devmate.dto.subscription.UsageTodayResponse

interface UsageService {
    fun getTodayUsageOfUser(userId: Long): UsageTodayResponse?
    fun getSubscriptionLimitsOfUser(userId: Long): PlanLimitResponse?
}

