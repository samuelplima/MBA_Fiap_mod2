package com.fiap.vivo.util

import java.util.*
import kotlin.math.absoluteValue

class GenerateSmsCode {

    var smsCode = ""
    private val random = Random()

    constructor()


    fun generateRandom() : Int{
        var value = 0
        for (i in 6 downTo 0) {
           value = random.nextInt().absoluteValue
        }
        this.smsCode = value.toString()
        return value
    }


}