package com.fiap.vivo.util

import android.content.Context
import com.fiap.vivo.databinding.RecoverPasswordBinding

class ValidateSMS {

    fun validateSMS(binding: RecoverPasswordBinding, smsCode: String) : Boolean{
        val userCode = binding.recoverPasswordPhoneField.text.toString()
        return smsCode == userCode
    }

}