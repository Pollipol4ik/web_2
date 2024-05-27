package com.example.jdbc.repository.interfaces

interface CardsRepository {

    fun getDesc(cardId: Int?): String

    fun getAuthor(cardId: Int?): Int

    fun getAssignee(cardId: Int?): Int

    fun getBoard(cardId: Int?): Int

    fun getStatus(cardId: Int?): Int
}