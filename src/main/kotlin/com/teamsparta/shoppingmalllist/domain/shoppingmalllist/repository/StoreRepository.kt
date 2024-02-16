package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {
}


