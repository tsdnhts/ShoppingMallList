import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.noarg") version "1.8.22"
	kotlin("plugin.jpa") version "1.9.22" // 이것도 다진님이 jpa 관련해서 사용하려고 추가하신듯
	kotlin("kapt") version "1.8.22" // QueryDSL
}

group = "com.teamsparta"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

noArg {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable") }

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable") }

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") // jpa data 관련
	implementation("org.springframework.boot:spring-boot-starter-actuator") // JpaRepository 사용을 위해 추가함
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.3")// readAllWithHeaderAsSequence 메서드 사용을 위한 추가


	// SWAGGER
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
	kapt("com.querydsl:querydsl-apt:5.1.0:jakarta")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
