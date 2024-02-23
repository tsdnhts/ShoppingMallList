package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.controller.request

import org.springframework.data.domain.Sort
import java.util.*

data class StoreRequest (
    var page : Long,
    var pagesize : Long,
    var sort : String?,
    var direction: Sort.Direction,
    // direction은 자동완성에서 나온 걸 사용했음(이 내용을 사용해도 된다고 튜터님의 승인을 받음)
    var properties: Properties?
    // properties도 타입을 무엇으로 할지 몰라 전구 자동완성에서 하나 골라잡음(튜터님 질문시 이 부분도 수정하라는 말씀은 X)
    // 벨로그 pageable 사용관련 게시글에 request 구성 요소 5가지를 그대로 옮겨서 적었다.
// var pageNo : Long,
// var criteria : String,
    // criteria는 정렬 기준
)

