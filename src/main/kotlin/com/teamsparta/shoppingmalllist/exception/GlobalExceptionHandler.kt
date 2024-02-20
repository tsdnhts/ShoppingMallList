package com.teamsparta.shoppingmalllist.exception

import com.teamsparta.shoppingmalllist.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ShoppingMallNotFoundException::class)
    fun handleShoppingMallNotFoundException(e:ShoppingMallNotFoundException) : ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(message = e.message))
    }
    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(e:IllegalStateException) : ResponseEntity<ErrorResponse>{
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ErrorResponse(message = e.message))
    }
}