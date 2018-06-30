package com.codingblocks.databases.models

data class Task (
        val id: Int?,
        val taskName: String,
        var done: Boolean
)