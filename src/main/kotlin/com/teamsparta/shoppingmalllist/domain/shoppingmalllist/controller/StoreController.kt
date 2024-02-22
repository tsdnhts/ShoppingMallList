package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.controller

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service.StoreService
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/stores")
@RestController
class StoreController(
    private val storeService : StoreService
) {
// 모든 가게 정보를 조회하기
    @GetMapping("/stores", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStores(): ResponseEntity<List<StoreResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStores())
    }

 // 전체 평가, 업소 상태 선택별 조회 하기(필터링)
    @GetMapping("/search")
    fun findStore(
     @RequestParam(required = false) score: Int?,
     @RequestParam(required = false) state: StoreState?
    ): ResponseEntity<List<StoreResponse>> {
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(storeService.findStores(score, state))
    }
    // Pagination을 사용하여 모든 가게 정보를 조회하기
    @GetMapping
    fun getStoresByPageable(pageable: Pageable) : ResponseEntity<List<StoreResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStoresByPageable(pageable))
    }

    // 특정 위치의 CSV 파일로부터 1개 행씩 데이터를 DB에 저장
    @PostMapping("/collection", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresFromCSV() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.collectStoresFromCSV())
    }

    //특정 위치의 CSV 파일로부터 전체 데이터를 DB에 저장
    @PostMapping("/collection2", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresFromCSV2() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.collectStoresFromCSV2())
    }

// API를 사용해서 데이터를 수집하기
    @PostMapping("/collection-api", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresByAPI() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.collectStoresByAPI())
    }
}