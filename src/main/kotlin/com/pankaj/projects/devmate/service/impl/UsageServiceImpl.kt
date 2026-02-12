package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.subscription.PlanLimitResponse
import com.pankaj.projects.devmate.dto.subscription.UsageTodayResponse
import com.pankaj.projects.devmate.service.UsageService
import org.springframework.stereotype.Service

@Service
class UsageServiceImpl : UsageService {
    override fun getTodayUsageOfUser(userId: Long): UsageTodayResponse? {
        TODO("Not yet implemented")
    }

    override fun getSubscriptionLimitsOfUser(userId: Long): PlanLimitResponse? {
        TODO("Not yet implemented")
    }
}