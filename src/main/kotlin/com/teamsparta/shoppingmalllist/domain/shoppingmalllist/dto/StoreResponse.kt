package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import java.time.LocalDateTime

data class StoreResponse (
 // 전체평가
 var score : Int,
 // 업소상태
 var state: StoreState,
 // 모니터링날짜
 var monitoringDate : LocalDateTime

    // 32개의 칼럼 중 여기에 어떤 칼럼이 들어가야 하는지?
)