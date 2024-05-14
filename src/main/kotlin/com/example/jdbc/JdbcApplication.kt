package com.example.jdbc

import com.example.jdbc.models.Person
import com.example.jdbc.repository.interfaces.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.server.Session
import org.springframework.util.DigestUtils
import java.util.*

/**
 * ЗАДАНИЕ:
 * 1. Создать базу данных с таблицами, описанными в диаграмме
 * 2. Настроить конфиг файл resources.application.yml
 * 3. Доработать написанный код для получения id пользователя по логину и паролю
 * 4. Добавить модели, интерфейсы и реализации для получения тикетов из базы
 */
@SpringBootApplication
class JdbcApplication

@Autowired
var profileRepository: ProfileRepository? = null

var userId: Int? = null

/**
 * Запускает приложение. На старте необходимо добавить создание пустого персона, сделать метод
 */
fun main(args: Array<String>) {
    runApplication<JdbcApplication>(*args)

    val incomingPerson = Person() //Создаем пустого персона (который в реальности лежал бы в сессии)

    login(incomingPerson) //Заполняем персона данными (как будто он ввел логин с паролем и прожал авторизацию)

    println(userId) //Выводим его id из БД
}

/**
 * Залогинить пользователя
 *
 * @param person заполненный пользователь
 */
fun login(person: Person) {
    userId = profileRepository?.getUser(
        person.login, person.password
    )
}

/**
 * Заглушка авторизации пользователя. В реальности это будет метод, который возвращает с фронта то, что пользователь
 * указал в логине и пароле. Здесь нужно записать данные пользователя, который сохранен в БД для вызова. Если их
 * несколько, сделайте свич кейс.
 */
fun authorise(person: Person){
    person.login = ""
    person.password = ""
}
