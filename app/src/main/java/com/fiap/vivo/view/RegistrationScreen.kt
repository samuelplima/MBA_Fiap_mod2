package com.fiap.vivo.view

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
import com.fiap.vivo.databinding.RegistrationScreenBinding
import com.fiap.vivo.model.User
import com.fiap.vivo.model.UserViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationScreen : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: RegistrationScreenBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = RegistrationScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        identificacaoPersistencia()

        binding.registrationButtonSave.setOnClickListener {
            insertDataToDatabase()
        }

    }

    fun identificacaoPersistencia(){
        val identificacaoPersistencia = this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            binding.registrationCpfCnpj.text = identificacaoPersistencia.getString("documento", "")
        }
    }

    private fun insertDataToDatabase() {
        val nome = binding.registrationNameField.text.toString()
        val email = binding.registrationEmailField.text.toString()
        val senha = binding.registrationPasswordField.text.toString()
        val plano = binding.editTextTextPersonName.text.toString()
        val situacao = "Em Análise!"
        var cnpjCpf = ""
        val identificacaoPersistencia = this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            cnpjCpf = identificacaoPersistencia.getString("documento", "").toString()
        }

        if (inputCheck(nome, cnpjCpf, email, plano, senha)) {
            //create user object
            val user = User(0, nome, cnpjCpf, email, plano, situacao, senha)
            //add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Salvo com sucesso!", Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_thirdFragment2_to_FirstFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Por favor preencha todos os campos!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    private fun inputCheck(nome: String, cnpjCpf: String, email: String, plano: String, senha: String): Boolean {
        return !(TextUtils.isEmpty(nome) && TextUtils.isEmpty(cnpjCpf) && TextUtils.isEmpty(email)  && TextUtils.isEmpty(plano) && TextUtils.isEmpty(senha))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

