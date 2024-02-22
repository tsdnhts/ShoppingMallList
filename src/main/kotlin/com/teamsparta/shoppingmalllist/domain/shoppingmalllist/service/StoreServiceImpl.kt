package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository.StoreRepository
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.stereotype.Service


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

    override fun getStoresByPageable(pageable: SpringDataWebProperties.Pageable): List<StoreResponse> {
        TODO("Not yet implemented")
    }

    override fun collectStoresFromCSV(): String {
        TODO("Not yet implemented")
    }

    override fun collectStoresFromCSV2(): String {
        TODO("Not yet implemented")
    }

    override fun collectStoresByAPI(): String {
        TODO("Not yet implemented")
    }
}