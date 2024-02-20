package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface StoreRepository : JpaRepository<Store, Long> {
//    fun findAll(pageable: Pageable): Page<Store>?
//    fun findByScoreAndState(score : Int, state : StoreState, pageable: Pageable) : Page<Store>
}
//interface ReviewRepository : JpaRepository<Review?, Long?> {
//    fun findAll(pageable: Pageable?): Page<Review?>?
// }