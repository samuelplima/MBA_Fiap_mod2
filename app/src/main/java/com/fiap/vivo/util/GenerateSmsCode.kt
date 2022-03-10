package com.fiap.vivo.util

import java.util.*

class GenerateSmsCode {

    val code = "1234"

    private val random = Random()

    fun generateRandom() : Int{
        var value = 0
        for (i in 6 downTo 0) {
           value = random.nextInt()
        }
        return value
    }


}