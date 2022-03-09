package com.fiap.vivo.util

import android.text.TextUtils
import android.util.Patterns

class EmailValidation {

    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}