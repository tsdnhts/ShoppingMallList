package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository.StoreRepository
import jakarta.transaction.Transactional
import org.apache.coyote.Response
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service



interface StoreService {


    fun findStores(score: Int?, state: StoreState?): List<StoreResponse>

    fun getStores() : List<StoreResponse>

    fun collectStoresFromCSV() : String
// 자료를 한번에 한개씩 읽어오기
    fun collectStoresFromCSV2() : String
// 자료를 한꺼번에 전부 읽어오기
    fun collectStoresByAPI() : String

    // api로 자료를 가져오기
}
