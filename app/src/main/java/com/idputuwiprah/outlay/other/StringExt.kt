package com.idputuwiprah.outlay.other

fun String.toCurrency(): String {
    var currency = ""
    var counter = 0
    this.reversed().forEach {
        currency += it
        counter++
        if (counter == 3) {
            currency += "."
            counter = 0
        }
    }
    return currency.reversed()
}