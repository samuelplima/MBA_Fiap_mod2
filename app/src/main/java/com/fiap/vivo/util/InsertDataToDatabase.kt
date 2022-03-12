package com.fiap.vivo.util

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.RegistrationScreenBinding
import com.fiap.vivo.data.model.User
import com.fiap.vivo.viewmodel.UserViewModel

class InsertDataToDatabase {

    private val radioOptionType = RadioOptionType()
    private val emailValidation = EmailValidation()
    private val identificacaoPersistencia = IdentificacaoPersistencia()
    private val inputCheck = InputCheck()

    fun insertDataToDatabase(binding: RegistrationScreenBinding, activity: Activity, userViewModel: UserViewModel, context: Context, findNavController: NavController) {
        val nome = binding.registrationNameField.text.toString()
        val email = binding.registrationEmailField.text.toString()
        val senha = binding.registrationPasswordField.text.toString()
        var plano = radioOptionType.radioOptionType(binding)
        val situacao = "Em Análise!"
        var cnpjCpf = identificacaoPersistencia.identificacaoPersistenciaRegistration(binding, activity)
        val telefone = binding.registrationPhoneField.text.toString()

        if (emailValidation.isValidEmail(email) && inputCheck.inputCheckRegistration(nome, cnpjCpf, telefone, email, plano, senha)) {
            val user = User(0, nome, cnpjCpf, telefone, email, plano, situacao, senha)
            userViewModel.addUser(user)
            Toast.makeText(context, "Salvo com sucesso!", Toast.LENGTH_LONG).show()
            findNavController.navigate(R.id.action_thirdFragment2_to_FirstFragment)
        } else {
            Toast.makeText(
                context,
                "Por favor preencha todos os campos!",
                Toast.LENGTH_LONG
            ).show()
        }
    }


}