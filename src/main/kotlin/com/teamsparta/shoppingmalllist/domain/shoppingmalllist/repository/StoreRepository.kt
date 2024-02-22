package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

// 우리가 Service 단에서 실제로 사용할 Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long>, JpaSpecificationExecutor<Store>, CustomStoreRepository {
}