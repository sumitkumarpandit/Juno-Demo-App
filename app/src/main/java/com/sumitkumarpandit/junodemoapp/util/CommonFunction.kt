package com.sumitkumarpandit.junodemoapp.util

// function to convert number to international number system format
fun convertToIntNumSys(number: String): String {
    var updatedNumber = ""
    var lastIdx = number.lastIndex
    // handling for decimal number string
    if (number.contains(".")) {
        for (i in number.lastIndex downTo 0) {
            updatedNumber = number[i] + updatedNumber
            if (number[i] == '.') {
                lastIdx = i - 1
                break
            }
        }
    }

    var count = 1
    for (idx in lastIdx downTo 1) {
        updatedNumber = if (count % 3 == 0) {
            ",${number[idx]}$updatedNumber"
        } else {
            number[idx] + updatedNumber
        }
        count++
    }
    return number[0] + updatedNumber
}