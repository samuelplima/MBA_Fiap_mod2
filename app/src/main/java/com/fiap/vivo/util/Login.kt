package com.fiap.vivo.util

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.fiap.vivo.R

class Login {

    val inputCheck = InputCheck()

    fun login(
        emailDB: String?,
        senhaDB: String?,
        email: String,
        senha: String,
        context: Context,
        findNavController: NavController
    ) {
        if (inputCheck.inputCheckLogin(email, senha)) {
            if (email == emailDB && senha == senhaDB) {
                findNavController.navigate(R.id.action_SecondFragment_to_fourthFragment)
                Toast.makeText(context, "Logado com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(
                context,
                "Por favor preencha todos os campos!",
                Toast.LENGTH_LONG
            ).show()
        } else if (emailDB == null || senhaDB == null) {
            Toast.makeText(context, "Email ou senha invalido", Toast.LENGTH_LONG).show()
        }
    }

}