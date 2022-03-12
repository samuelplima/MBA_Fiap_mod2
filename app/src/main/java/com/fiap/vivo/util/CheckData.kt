package com.fiap.vivo.util

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.navigation.NavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.InitialScreenBinding

class CheckData {

    private val checkCpfCnpj = CheckCpfCnpj()

    private var checkData: Boolean = false


    fun checkData(
        binding: InitialScreenBinding,
        cpfCnpjUser: String?,
        cpfCnpjDB: String?,
        findNavController: NavController,
        activity: Activity
    ) {
        fun sharedPreferrences() {
            val identificacaoPersistencia =
                activity.getSharedPreferences(
                    "identificacao",
                    Context.MODE_PRIVATE
                )
            val editor = identificacaoPersistencia?.edit()
            if (editor != null) {
                editor.putString("documento", binding.requireCpfCnpjField.text.toString())
                editor.apply()
            }
        }

        when (binding.requireCpfCnpjField.text.length) {
            14 -> {
                if (checkCpfCnpj.checkCpf(binding.requireCpfCnpjField.text.toString())) {
                    checkData = true
                } else {
                    binding.docCheck.text = "CPF inválido"
                    binding.docCheck.setTextColor(Color.RED)
                    checkData = false
                }
            }
            18 -> {
                if (checkCpfCnpj.checkCpf(binding.requireCpfCnpjField.text.toString())) {
                    checkData = true
                } else {
                    binding.docCheck.text = "CNPJ inválido"
                    binding.docCheck.setTextColor(Color.RED)
                    checkData = false
                }
            }
            else -> {
                binding.docCheck.text = "Não é um CPF nem CNPJ válido."
                checkData = false
            }
        }
        if (checkData) {
            if (cpfCnpjUser == cpfCnpjDB) {
                sharedPreferrences()
                findNavController.navigate(R.id.action_FirstFragment_to_SecondFragment)
            } else {
                sharedPreferrences()
                findNavController.navigate(R.id.action_FirstFragment_to_thirdFragment2)
            }
        }
    }


}