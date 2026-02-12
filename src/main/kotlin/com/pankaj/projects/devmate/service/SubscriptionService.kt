package com.pankaj.projects.devmate.service

import com.pankaj.projects.devmate.dto.subscription.CheckoutRequest
import com.pankaj.projects.devmate.dto.subscription.CheckoutResponse
import com.pankaj.projects.devmate.dto.subscription.PortalResponse
import com.pankaj.projects.devmate.dto.subscription.SubscriptionResponse

interface SubscriptionService {
    fun getCurrentSubscription(userId: Long): SubscriptionResponse?
    fun createCheckoutSessionUrl(request: CheckoutRequest, userId: Long): CheckoutResponse?
    fun openCustomerPortal(userId: Long): PortalResponse?
}


