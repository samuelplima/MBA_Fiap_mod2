package com.fiap.vivo.util

import java.util.*
import kotlin.math.absoluteValue

class GenerateSmsCode {

    private val random = Random()

    fun generateRandom() : Int{
        var value = 0
        for (i in 6 downTo 0) {
           value = random.nextInt().absoluteValue
        }
        return value
    }


}