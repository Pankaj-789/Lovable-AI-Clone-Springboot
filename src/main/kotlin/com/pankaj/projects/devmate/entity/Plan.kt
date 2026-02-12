package com.pankaj.projects.devmate.entity

class Plan (
    var id : Long? = null,
    var name : String,
    var stripePriceId : String,
    var maxProjects : Integer,
    var maxTokensPerDay : Integer,
    var maxPreviews : Integer,
    var unlimitedAi : Boolean,
    var active : Boolean


    )