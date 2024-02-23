package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model


import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext
import jakarta.persistence.Convert
import org.aspectj.weaver.tools.cache.SimpleCacheFactory.path
import java.io.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.sound.sampled.Line


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

    companion object {
        fun valueOf(description: String): StoreState
            = entries.first { it.description == description }
    }
 /*   근데 @Convert사용안하고 간단히 String to localdatetime으로 검색해도 요되
    오 바로 해보겠습니다https://www.baeldung.com/kotlin/string-to-date
    https://www.baeldung.com/kotlin/date-time-string-to-instant
    열심히 하는 것 같아 기특함
    @Convert(converter = Local)
    */
//companion object {
//    fun valueOfOrNull(value: String): StoreState? {
//        return values().find { it.name == value }
//    }
//}
//    companion object {
//        val DEFAULT_STATE = OPEN// 기본 상태를 지정하세요
//    }
//
// fun OutputStream.writeCsv(goods: List<TaxableGood>) {
//     csvMapper.writer().with(schema.withHeader()).writeValues(this).writeAll(goods)
// }
//    var line: String?
//    while (reader.readLine().also { line = it } != null) {
//        // 각 라인에 대한 처리 수행
//        println(line)
//}
//    try {
//        //utf-8 형태로 csv 파일 파싱
//        CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(path + "\\src\\main\\java\\jh\\ParkingService\\repository\\park\\data.csv"), "EUC-KR"));
//        csvReader.readNext(); // 컬럼명은 저장되지 않도록 한 줄 읽기
//}
//    }
//fun main() {
//    val file = File("src/main/resources/file.csv")
//    try {
//        BufferedReader(FileReader(file)).use { br ->
//            br.lines().forEach { println(it) }
//        }
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
//}
//fun Reader.readLines(): Line<String> {
//    val userLines = FileReader("data.bin").use { it.readLines() }
//    return userLines
//}
fun main() {
//    val csvReader = CsvReader(FileReader("src/main/resources/file.csv"))
//     val csvReader = CsvReader(InputStreamReader(FileInputStream("src/main/resources/file.csv"), "EUC-KR"));
     val csvReader = CsvReader();
// read from `java.io.File`
     val file: File = File("src/main/resources/file.csv")
     val rows: List<List<String>> = csvReader.readAll(file)
     // 첫 번째 행 건너뛰기
//    csvReader.readNext()
//    // 나머지 행 읽기
//    csvReader.forEach {
//        println(it)
//    }
//    csvReader.close()
}

//var LocalDateTime = LocalDateTime.parse(dateStr, formatter)
//fun givenString_whenCustomFormat_thenLocalDateTimeCreated() {
//    val text = "2022-01-06 20:30:45"
//    val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//    val localDateTime = LocalDateTime.parse(text, pattern)
//
//    Assertions.assertThat(localDateTime).isEqualTo("2022-01-06T20:30:45")
}


// 순서대로 사이트 운영중단, 휴업중, 광고용, 등록정보불일치, 사이트 폐쇄, 영업중, 확인안됨