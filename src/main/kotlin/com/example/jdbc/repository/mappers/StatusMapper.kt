package com.example.jdbc.repository.mappers

import com.example.jdbc.repository.models.Status
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.sql.SQLException


@Component
class StatusMapper : RowMapper<Status?> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Status {
        return Status(
            rs.getInt("statusId"),
            rs.getString("name")
        )
    }
}