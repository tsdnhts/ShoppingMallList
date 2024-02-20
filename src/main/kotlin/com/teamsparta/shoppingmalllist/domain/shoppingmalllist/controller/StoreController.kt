package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.controller

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service.StoreService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RequestMapping("/stores")
@RestController
class StoreController(
    private val storeService : StoreService
) {
// 모든 가게 정보를 조회하기
    // 작성하다 보니 기준에 맞게 특정 페이지수 정렬하여 조회로 작성되었음
    // 정렬 기준은 monitoringDate 으로 임의 설정하였으며, 추후 변경이 필요 시 바꿀 것
    @GetMapping("/stores", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStores(@RequestParam(required = false, defaultValue = "0", value = "page") pageNo: Int,
                  @RequestParam(required = false, defaultValue = "monitoringDate", value = "criteria") criteria: String?): ResponseEntity<MutableList<StoreResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStores(pageNo, criteria))
    }

//     Pagination을 사용하여 모든 가게 정보를 조회하기
    @GetMapping
    fun getStoresByPageable(pageable: Pageable) : ResponseEntity<List<StoreResponse>>{
        val status = "OPEN" // OPEN 상태의 가게만 가져오도록 설정
        val score = 3 // 3점 이상의 가게만 가져오도록 설정
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
