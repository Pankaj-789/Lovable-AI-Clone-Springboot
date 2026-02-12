package com.pankaj.projects.devmate.dto.subscription

data class UsageTodayResponse(
    val tokensUsed : Int,
    val tokensLimit : Int,
    val previewsRunning : Int,
    val previewsLimit : Int

)
