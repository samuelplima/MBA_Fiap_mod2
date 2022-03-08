package com.fiap.vivo.util

import android.text.TextUtils

class InputCheck {

    fun inputCheckLogin(email : String, senha : String): Boolean {
        return !(TextUtils.isEmpty(email) || TextUtils.isEmpty(senha))
    }

    fun inputCheckRegistration(
        nome: String,
        cnpjCpf: String,
        email: String,
        plano: String,
        senha: String
    ): Boolean {
        return !(TextUtils.isEmpty(nome) || TextUtils.isEmpty(cnpjCpf) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
            plano
        ) || TextUtils.isEmpty(senha))
    }

}