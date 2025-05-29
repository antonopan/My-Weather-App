package com.nile.pantelis.myweatherapp.domain.utils

fun keepOneDecimal(input: String): String {
    val dotIndex = input.indexOf('.')
    return if (dotIndex == -1 || dotIndex == input.lastIndex) {
        // No decimal or decimal is last char
        input
    } else {
        // Keep everything up to one digit after decimal
        input.substring(0, dotIndex + 2)
    }
}