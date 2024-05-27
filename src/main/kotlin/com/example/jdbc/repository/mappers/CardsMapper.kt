package com.example.jdbc.repository.mappers

import com.example.jdbc.repository.models.Card
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.sql.SQLException


@Component
class CardsMapper : RowMapper<Card?> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Card {
        return Card(
            rs.getInt("cardid"),
            rs.getString("description"),
            rs.getInt("authorid"),
            rs.getInt("assigneeid"),
            rs.getInt("boardid"),
            rs.getInt("statusid")
        )
    }
}