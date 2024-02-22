package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState

// 커스텀 메서드들을 선언하는 Repository

interface CustomStoreRepository {
    fun searchStores(score: Int?, state: StoreState?): List<Store>
}