package com.pankaj.projects.devmate.service.impl

import com.pankaj.projects.devmate.dto.subscription.CheckoutRequest
import com.pankaj.projects.devmate.dto.subscription.CheckoutResponse
import com.pankaj.projects.devmate.dto.subscription.PortalResponse
import com.pankaj.projects.devmate.dto.subscription.SubscriptionResponse
import com.pankaj.projects.devmate.service.SubscriptionService
import org.springframework.stereotype.Service

@Service
class SubscriptionServiceImpl: SubscriptionService {
    override fun getCurrentSubscription(userId: Long): SubscriptionResponse? {
        TODO("Not yet implemented")
    }

    override fun createCheckoutSessionUrl(
        request: CheckoutRequest,
        userId: Long
    ): CheckoutResponse? {
        TODO("Not yet implemented")
    }

    override fun openCustomerPortal(userId: Long): PortalResponse? {
        TODO("Not yet implemented")
    }
}