package com.teamsparta.shoppingmalllist

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@SpringBootConfiguration
@SpringBootApplication
class ShoppingMallListApplication

fun main(args: Array<String>) {
	runApplication<ShoppingMallListApplication>(*args)
}
