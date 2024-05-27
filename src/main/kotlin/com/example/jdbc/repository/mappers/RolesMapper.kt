package com.example.jdbc.repository.mappers

import com.example.jdbc.repository.models.Role
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.sql.SQLException


@Component
class RolesMapper : RowMapper<Role?> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Role {
        return Role(
            rs.getInt("roleId"),
            rs.getString("name")
        )
    }
}