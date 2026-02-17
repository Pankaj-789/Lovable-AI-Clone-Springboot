package com.pankaj.projects.devmate.dto.member

import com.pankaj.projects.devmate.enums.ProjectRole

data class InviteMemberRequest(
   val email : String,    /*email of the person who we want to invite*/
    val role : ProjectRole  /*which rule we have to give that person*/
)
