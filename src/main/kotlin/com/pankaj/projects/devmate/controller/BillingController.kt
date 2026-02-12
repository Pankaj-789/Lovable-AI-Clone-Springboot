package com.pankaj.projects.devmate.controller

import com.pankaj.projects.devmate.dto.subscription.CheckoutRequest
import com.pankaj.projects.devmate.dto.subscription.CheckoutResponse
import com.pankaj.projects.devmate.dto.subscription.PlanResponse
import com.pankaj.projects.devmate.dto.subscription.PortalResponse
import com.pankaj.projects.devmate.dto.subscription.SubscriptionResponse
import com.pankaj.projects.devmate.service.PlanService
import com.pankaj.projects.devmate.service.SubscriptionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class BillingController(private val planService: PlanService, private val subscriptionService: SubscriptionService) {

    @GetMapping("/api/plans")
    fun getAllPlans(): ResponseEntity<List<PlanResponse>> {
        return ResponseEntity.ok(planService.getAllActivePlans())

    }

    @GetMapping("/api/me/subscription")
    fun getMySubscription(): ResponseEntity<SubscriptionResponse> {
        val userId = 1L
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId))

    }

    @PostMapping("/api/razorpay/checkout")
    fun createCheckoutResponse(@RequestBody request: CheckoutRequest): ResponseEntity<CheckoutResponse> {
        val userId = 1L
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request, userId))
    }

    @PostMapping("/api/razorpay/portal")
    fun openCustomerPortal() : ResponseEntity<PortalResponse>{
        val userId = 1L
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId))

    }
}