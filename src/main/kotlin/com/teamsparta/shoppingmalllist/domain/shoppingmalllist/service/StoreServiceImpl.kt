package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.service

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository.StoreRepository
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {

    override fun getStores(pageNo: Int, criteria: String?): MutableList<StoreResponse> {
        val pageable: Pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, criteria))
        val page = storeRepository.findAll(pageable).map { it.toResponse() }
        return (page.content)
    }

    override fun getStoresByPageable(pageable: Pageable): List<StoreResponse> {
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