package com.pankaj.projects.devmate.entity

import com.pankaj.projects.devmate.enums.SubscriptionStatus
import java.time.Instant

class Subscription(
    var id : Long,

    var user : User,

    var plan : Plan,

    var status: SubscriptionStatus,

    var stripeCustomerId : String,

    var stripeSubscriptionId : String,

    var currentPeriodStart : Instant,

    var currentPeriodEnd : Instant,

    var cancelAtPeriodEnd : Boolean = false,

    var createdAt: Instant,

    var updatedAt : Instant


)