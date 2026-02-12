package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.subscription.PlanLimitResponse
import com.pankaj.projects.devmate.dto.subscription.UsageTodayResponse
import com.pankaj.projects.devmate.service.UsageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/usage")
class UsageController(private val usageService : UsageService) {

    @GetMapping("/today")
    fun getTodayUsage() : ResponseEntity<UsageTodayResponse>{
        val userId = 1L
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId))
    }

    @GetMapping("/limits")
    fun getPlanLimits() : ResponseEntity<PlanLimitResponse>{
        val userId = 1L
        return ResponseEntity.ok(usageService.getSubscriptionLimitsOfUser(userId))
    }

}