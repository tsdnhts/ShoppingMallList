package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.controller.request

import org.springframework.data.domain.Sort
import java.util.*

data class StoreRequest (
    var page : Long,
    var pagesize : Long,
    var sort : String?,
    var direction: Sort.Direction,
    // direction은 자동완성에서 나온 걸 사용했음
    var properties: Properties?
    // properties도 타입을 무엇으로 할지 몰라 전구 자동완성에서 하나 골라잡음
// var pageNo : Long,
// var criteria : String,
    // criteria는 정렬 기준
)

