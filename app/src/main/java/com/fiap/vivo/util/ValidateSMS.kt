package com.fiap.vivo.util

import android.content.Context
import com.fiap.vivo.databinding.RecoverPasswordBinding

class ValidateSMS {

    private val generateSmsCode = GenerateSmsCode()

    fun validateSMS(binding: RecoverPasswordBinding) : Boolean{
        val smsCode = generateSmsCode.code
        val userCode = binding.registrationPhoneField.text.toString()
        return smsCode == userCode
    }

}