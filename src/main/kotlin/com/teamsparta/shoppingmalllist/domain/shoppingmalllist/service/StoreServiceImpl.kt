package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository.StoreRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader // collectStoresFromCSV 함수 사용을 위한 추가
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState.Companion.valueOf
//import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.givenString_whenCustomFormat_thenLocalDateTimeCreated


@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {

    override fun findStores(score: Int?, state: StoreState?): List<StoreResponse> {
        return storeRepository.searchStores(score, state)
             .map { StoreResponse.from(it) }
    }

    override fun getStores(): List<StoreResponse> {
        TODO("Not yet implemented")
    }

    override fun collectStoresFromCSV() : String {
        csvReader().open("src/main/resources/file.csv") {
            readAllAsSequence().forEachIndexed { index, row: List<String> ->
                if (index!=0) {
                    storeRepository.save(
                        Store(
                            name = row[0],
                            url = row[2],
                            phone = row[3],
                            email = row[4],
                            address = row[8],
                            state = valueOf(row[9]),
                            score = row[10].toInt(),
                            monitoringDate = row[31]
                        )
                    )
                }

            }
        } ; return "데이터 입력을 시작합니다."
    }

    override fun collectStoresFromCSV2(): String {
        TODO("Not yet implemented")
    }

    override fun collectStoresByAPI(): String {
        TODO("Not yet implemented")
    }
}