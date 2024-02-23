package com.teamsparta.shoppingmalllist.exception

data class ShoppingMallNotFoundException(val ShoppingMallName : String, val id : Long) : RuntimeException(
    "ShoppingMall $ShoppingMallName not found with given id : $id"
)