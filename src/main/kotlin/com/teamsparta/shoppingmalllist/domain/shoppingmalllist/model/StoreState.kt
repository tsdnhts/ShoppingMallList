package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model

import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext
import com.fasterxml.jackson.annotation.JsonCreator
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import org.apache.commons.lang3.EnumUtils
import java.io.File

enum class StoreState(
  val description: String
  ) {
    STOPPED_SITE("사이트운영중단"),
    CLOSING("휴업중"),
    PROMOTION("광고용(홍보용)"),
    INFORMATION_MISMATCH("등록정보불일치"),
    SITE_CLOSE("사이트폐쇄"),
    OPEN("영업중"),
    NOT_CHECKED("확인안됨");
    // 이넘클래스를 리퀘스트파람으로 받기 위한 설정
//    companion object {
//
//    }

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun parse(name: String?): StoreState? =
            name?.let { EnumUtils.getEnumIgnoreCase(StoreState::class.java, it.trim()) }
        fun valueOf(description: String): StoreState
            = entries.first { it.description == description }
    }


fun main() {
     val csvReader = CsvReader();
// read from `java.io.File`
     val file: File = File("src/main/resources/file.csv")
     val rows: List<List<String>> = csvReader.readAll(file)
 }
}


