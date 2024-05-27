package com.example.jdbc.repository.mappers

import com.example.jdbc.repository.models.Board
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.sql.SQLException


@Component
class BoardMapper : RowMapper<Board?> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Board {
        return Board(
            rs.getInt("boardId"),
            rs.getString("title")
        )
    }
}