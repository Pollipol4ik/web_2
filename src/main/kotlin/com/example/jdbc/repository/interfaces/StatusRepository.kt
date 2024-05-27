package com.example.jdbc.repository.interfaces

interface StatusRepository {
    fun getStatus(statusId: Int?): Int

    fun getName(name: String?): String
}