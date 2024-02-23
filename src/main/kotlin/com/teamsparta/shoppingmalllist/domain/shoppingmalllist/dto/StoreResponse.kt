package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort.Direction
import java.time.LocalDateTime
import java.util.Properties


data class StoreResponse (

    val id: Long,
    val name: String, // 상호명
    val url: String, // 도메인
    val phone: String?, // 대표 번호
    val email: String, // 이메일
    val score : Int,  // 전체 평가
    val state: StoreState, // 업소 상태
    val monitoringDate : String, // 모니터링 날짜
) {

    // 엔티티 객체를 Response 객체로 바꿔주는 것
  companion object {
    fun from(store: Store): StoreResponse {
        return StoreResponse(
            id = store.id!!,
            name = store.name,
            url = store.url,
            phone = store.phone,
            email = store.email,
            score = store.score,
            state = store.state,
            monitoringDate = store.monitoringDate
        )
    }
  }
}

