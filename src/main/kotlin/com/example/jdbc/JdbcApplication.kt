package com.example.jdbc

import com.example.jdbc.models.Card
import com.example.jdbc.models.Person
import com.example.jdbc.repository.impls.CardRepositoryImpl
import com.example.jdbc.repository.impls.ProfileRepositoryImpl
import com.example.jdbc.repository.interfaces.CardsRepository
import com.example.jdbc.repository.interfaces.ProfileRepository
import com.example.jdbc.repository.mappers.CardsMapper
import com.example.jdbc.repository.mappers.UsersMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

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

@Autowired
var cardRepository: CardsRepository? = null

var userId: Int? = null

@Bean
fun connect(): DataSource {
    return DriverManagerDataSource().apply {
        setDriverClassName("org.postgresql.Driver")
        url = "jdbc:postgresql://localhost:15432/postgres"
        username = "postgres"
        password = "postgres"
    }
}

/**
 * Запускает приложение. На старте необходимо добавить создание пустого персона, сделать метод
 */
fun main(args: Array<String>) {

    profileRepository = ProfileRepositoryImpl(UsersMapper(), NamedParameterJdbcTemplate(connect()))
    cardRepository = CardRepositoryImpl(CardsMapper(), NamedParameterJdbcTemplate(connect()))
    runApplication<JdbcApplication>(*args)

    val incomingPerson = Person() //Создаем пустого персона (который в реальности лежал бы в сессии)
    incomingPerson.login = "user"
    incomingPerson.password = "qwerty"
    val card = Card()
    card.cardId = 1

    authorise(incomingPerson)
    login(incomingPerson) //Заполняем персона данными (как будто он ввел логин с паролем и прожал авторизацию)

    println(userId) //Выводим его id из БД
    cardInfo(card)
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

fun cardInfo(card: Card) {
    println(cardRepository?.getDesc(card.cardId))

    println(cardRepository?.getStatus(card.cardId))

    println(cardRepository?.getBoard(card.cardId))

    println(cardRepository?.getAuthor(card.cardId))
    println(cardRepository?.getAssignee(card.cardId))
}

/**
 * Заглушка авторизации пользователя. В реальности это будет метод, который возвращает с фронта то, что пользователь
 * указал в логине и пароле. Здесь нужно записать данные пользователя, который сохранен в БД для вызова. Если их
 * несколько, сделайте свич кейс.
 */
fun authorise(person: Person) {
    person.login = "user"
    person.password = "qwerty"
}