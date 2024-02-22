package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model

import com.fasterxml.jackson.annotation.JsonCreator
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import org.apache.commons.lang3.EnumUtils

enum class StoreState() {
    STOPPED_SITE, CLOSING, PROMOTION, INFORMATION_MISMATCH, SITE_CLOSURE, OPEN, NOT_CHECKED;
                      // 순서대로 사이트 운영중단, 휴업중, 광고용, 등록정보불일치, 사이트 폐쇄, 영업중, 확인안됨

    // 이넘클래스를 리퀘스트파람으로 받기 위한 설정
    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun parse(name: String?): StoreState? =
            name?.let { EnumUtils.getEnumIgnoreCase(StoreState::class.java, it.trim()) }
    }
}

