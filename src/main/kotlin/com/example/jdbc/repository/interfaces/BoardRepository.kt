package com.example.jdbc.repository.interfaces

interface BoardRepository {
    fun getBoard(boardId: Int?): Int

    fun getTitle(title: String?): String
}