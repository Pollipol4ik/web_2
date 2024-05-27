package com.example.jdbc.repository.models;

/**
 * Модель для идентификации пользователя из БД
 *
 * @param userid идентификатор
 */
public record User(int userid, String login, String password, String name, int roleId) {


}
