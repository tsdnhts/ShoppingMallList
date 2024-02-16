package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.stereotype.Service

@Service
interface StoreService {

    fun getStores() : List<StoreResponse>

    fun getStoresByPageable(pageable: SpringDataWebProperties.Pageable) : List<StoreResponse>
// 오류를 해결하다 보니 pageable : pageable에서
    // pageable : SpringDataWebProperties.Pageable로 바뀌었음

    fun collectStoresFromCSV() : String

    fun collectStoresFromCSV2() : String

    fun collectStoresByAPI() : String
}
