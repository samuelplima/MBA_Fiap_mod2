package com.fiap.vivo.util

import android.content.Context
import com.fiap.vivo.databinding.RecoverPasswordBinding

class ValidateSMS {

    lateinit var userCode: String
    lateinit var smsCode: String

    fun validateSMS(): Boolean {
        return smsCode == userCode
    }

}