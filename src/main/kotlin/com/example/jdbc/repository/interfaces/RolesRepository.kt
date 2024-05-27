package com.example.jdbc.repository.interfaces


interface RolesRepository {

    fun getRole(roleId: Int?): Int

    fun getName(name: String?): String
}