package com.pankaj.projects.devmate.entity

import com.pankaj.projects.devmate.enums.MessageRole
import java.time.Instant

class ChatMessage(
    var id : Long,
    var chatSession: ChatSession,
    var content : String,
    var role : MessageRole,
    var toolCalls : String, //JSON array of tools called
    var tokensUsed : Integer,
    var createdAt : Instant


) {
}