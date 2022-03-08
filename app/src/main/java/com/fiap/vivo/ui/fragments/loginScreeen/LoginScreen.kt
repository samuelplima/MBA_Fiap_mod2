package com.fiap.vivo.ui.fragments.loginScreeen

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.LoginScreenBinding
import com.fiap.vivo.databinding.RegistrationScreenBinding
import com.fiap.vivo.ui.fragments.registrationScreen.RegistrationScreen
import com.fiap.vivo.util.IdentificacaoPersistencia
import com.fiap.vivo.util.Login
import com.fiap.vivo.viewmodel.UserViewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
open class LoginScreen : Fragment() {

    private val login = Login()

    private val identificacaoPersistencia = IdentificacaoPersistencia()

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: LoginScreenBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = LoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cnpjCpf = identificacaoPersistencia.identificacaoPersistenciaLogin(binding, this.requireActivity())

        binding.loginPageWelcomeText.text = "Olá, " + mUserViewModel.findName(cnpjCpf)

        binding.loginPageSaveButton.setOnClickListener {
            val email = binding.loginPageEmailField.text.toString()
            val senha = binding.loginPagePasswordField.text.toString()
            val emailDB = mUserViewModel.findEmail(email)
            val senhaDB = mUserViewModel.findPassword(senha)

            login.login(emailDB, senhaDB, email, senha, this.requireContext(), findNavController())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}