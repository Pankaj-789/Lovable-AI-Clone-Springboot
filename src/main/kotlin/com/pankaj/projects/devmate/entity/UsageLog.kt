package com.pankaj.projects.devmate.entity

import java.time.Instant

class UsageLog(
    var id : Long,
    var user: User,
    var project: Project,
    var action : String,
    var tokenUsed : Integer,
    var durationMs : Integer,
    var metaData : String , //JSON of {model_used, prompt_used}
    var createdAt : Instant
) 