package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto.StoreResponse
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "stores")
class Store(
    @Column(name = "name")
    val name: String, // 상호명

    @Column(name = "url")
    val url: String, // 도메인

    @Column(name = "phone")
    val phone: String?, // 대표 번호

    @Column(name = "email")
    val email: String, // 대표 이메일

    @Column(name = "score")
    val score : Int, // 전체 평가 점수

    @Column(name = "monitoringDate")
    val monitoringDate: String, // 모니터링 날짜

    @Column(name = "store_state")
    @Enumerated(EnumType.STRING)
    var state: StoreState, // 상태

    @Column(name = "address")
    val address: String,
) {
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

    //storeresponse 구현을 위해 생성하였음
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    // 필수 구현 과제 중 업체 리스트 조회 중 필터기능 사용시
    // 1) 전체평가 필터, 2) 업소상태 필터가 조회가 되어야 하므로
    // id에서 요구하는 값에 점수와, 업소 상태, 그리고 업소 이름이 포함되어야 할 것 같아 추후 세부 값 추가할 계획
}