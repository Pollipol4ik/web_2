package com.example.jdbc.repository.impls

import com.example.jdbc.repository.interfaces.CardsRepository
import com.example.jdbc.repository.mappers.CardsMapper
import com.example.jdbc.repository.models.Card
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CardRepositoryImpl(
    cardsMapperInit: CardsMapper,
    jdbcTemplate: NamedParameterJdbcTemplate
) : CardsRepository {
    private val cardsMapper: CardsMapper
    private val jdbcTemplate: NamedParameterJdbcTemplate

    init {
        cardsMapper = cardsMapperInit
        this.jdbcTemplate = jdbcTemplate
    }


    override fun getDesc(cardId: Int?): String {
        val params = MapSqlParameterSource()

        params.addValue("cardId", cardId)

        val result: Optional<Card?> = jdbcTemplate.query(
            SQL_GET_DESC_BY_ID,
            params,
            cardsMapper
        ).stream()
            .findFirst()
        return if (result.isEmpty) "-1" else result.get().description()
    }

    override fun getAuthor(cardId: Int?): Int {
        val params = MapSqlParameterSource()

        params.addValue("cardId", cardId)

        val result: Optional<Card?> = jdbcTemplate.query(
            SQL_GET_DESC_BY_ID,
            params,
            cardsMapper
        ).stream()
            .findFirst()
        return if (result.isEmpty) 0 else result.get().authorId()
    }

    override fun getAssignee(cardId: Int?): Int {
        val params = MapSqlParameterSource()

        params.addValue("cardId", cardId)

        val result: Optional<Card?> = jdbcTemplate.query(
            SQL_GET_DESC_BY_ID,
            params,
            cardsMapper
        ).stream()
            .findFirst()
        return if (result.isEmpty) 0 else result.get().assigneeId()
    }

    override fun getBoard(cardId: Int?): Int {
        val params = MapSqlParameterSource()

        params.addValue("cardId", cardId)

        val result: Optional<Card?> = jdbcTemplate.query(
            SQL_GET_DESC_BY_ID,
            params,
            cardsMapper
        ).stream()
            .findFirst()
        return if (result.isEmpty) 0 else result.get().boardId()
    }

    override fun getStatus(cardId: Int?): Int {
        val params = MapSqlParameterSource()

        params.addValue("cardId", cardId)

        val result: Optional<Card?> = jdbcTemplate.query(
            SQL_GET_DESC_BY_ID,
            params,
            cardsMapper
        ).stream()
            .findFirst()
        return if (result.isEmpty) 0 else result.get().statusId()
    }

    /**
     * Запросы к БД
     */
    companion object {
        private const val SQL_GET_DESC_BY_ID = "select * from card where cardid = :cardId"
//        private const val SQL_GET_AUTHOR_BY_ID = "select authorid, cardid from card where cardid = :cardId"
//        private const val SQL_GET_ASSIGNEE_BY_ID = "select assigneeid, cardid from card where cardid = :cardId"
//        private const val SQL_GET_BOARD_BY_ID = "select boardid, cardid from card where cardid = :cardId"
//        private const val SQL_GET_STATUS_BY_ID = "select statusid, cardid from card where cardid = :cardId"
    }

}