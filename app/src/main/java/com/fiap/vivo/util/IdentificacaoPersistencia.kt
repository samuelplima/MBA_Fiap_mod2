package com.fiap.vivo.util

import android.app.Activity
import android.content.Context
import com.fiap.vivo.databinding.*

class IdentificacaoPersistencia {

    fun identificacaoPersistenciaRegistration(
        binding: RegistrationScreenBinding,
        activity: Activity
    ): String {
        var value = ""
        val identificacaoPersistencia =
            activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            binding.registrationCpfCnpj.text = identificacaoPersistencia.getString("documento", "")
            value = identificacaoPersistencia.getString("documento", "").toString()
        }
        return value
    }

    fun identificacaoPersistenciaLogin(binding: LoginScreenBinding, activity: Activity): String {
        var value = ""
        val identificacaoPersistencia =
            activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            value = identificacaoPersistencia.getString("documento", "").toString()
        }
        return value
    }

    fun identificacaoPersistenciaDashboard(
        binding: DashboardScreenBinding,
        activity: Activity
    ): String {
        var value = ""
        val identificacaoPersistencia =
            activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            value = identificacaoPersistencia.getString("documento", "").toString()
        }
        return value
    }

    fun identificacaoPersistenciaRecover(
        binding: RecoverPasswordBinding,
        activity: Activity
    ): String {
        var value = ""
        val identificacaoPersistencia =
            activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            binding.recoverPasswordCpfCnpj.text = identificacaoPersistencia.getString("documento", "")
            value = identificacaoPersistencia.getString("documento", "").toString()
        }
        return value
    }

    fun identificacaoPersistenciaPassword(
        binding: ChangePasswordScreenBinding,
        activity: Activity
    ): String {
        var value = ""
        val identificacaoPersistencia =
            activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            binding.changePasswordCpfCnpj.text = identificacaoPersistencia.getString("documento", "")
            value = identificacaoPersistencia.getString("documento", "").toString()
        }
        return value
    }

}