package com.fiap.vivo.util

import com.fiap.vivo.databinding.RegistrationScreenBinding

class RadioOptionType {

    fun radioOptionType(binding: RegistrationScreenBinding): String {
        var plano = ""
        if (binding.registrationTypeCombo.isChecked) {
            plano = binding.registrationTypeCombo.text.toString()
        } else if (binding.registrationTypeInternet.isChecked) {
            plano = binding.registrationTypeInternet.text.toString()
        } else if (binding.registrationTypePhone.isChecked) {
            plano = binding.registrationTypePhone.text.toString()
        }
        return plano
    }

}