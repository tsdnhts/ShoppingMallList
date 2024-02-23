package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.dto

import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort.Direction
import java.time.LocalDateTime
import java.util.Properties


data class StoreResponse (
 // 전체평가
 var score : Int,
 // 업소상태
 var state: StoreState,
 // 모니터링날짜
 var monitoringDate : String,

 var name : String

    // 32개의 칼럼 중 여기에 어떤 칼럼이 들어가야 하는지?
)

//PageRequest(int page, int size)
//PageRequest(int page, int size, Sort sort)
//PageRequest(int page, int size, Sort.Direction direction, String... properties)
//
//var pageRequest: PageRequest = PageRequest.of(0, 10, Sort.by("id").ascending())
//PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id").ascending());
// 요 자바 코드를 보고 위에 값을 임의작성해봄