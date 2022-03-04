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
import com.fiap.vivo.databinding.FragmentSecondBinding
import com.fiap.vivo.model.User
import com.fiap.vivo.model.UserViewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
open class SecondFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentSecondBinding? = null

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cnpjCpf = ""
        val identificacaoPersistencia = this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            cnpjCpf = identificacaoPersistencia.getString("documento", "").toString()
        }
        binding.loginPageWelcomeText.text = "Olá, " + mUserViewModel.findName(cnpjCpf)

        binding.loginPageSaveButton.setOnClickListener {
            login()
        }
    }

    private fun login(){
        val email = binding.loginPageEmailField.text.toString()
        val senha = binding.loginPagePasswordField.text.toString()
        val emailDB = mUserViewModel.findEmail(email)
        val senhaDB = mUserViewModel.findPassword(senha)

        if(emailDB == null || senhaDB == null) {
            Toast.makeText(requireContext(), "Email ou senha invalido", Toast.LENGTH_LONG).show()
        }
        if (inputCheck(email, senha)) {
            if(email == emailDB && senha == senhaDB){
                findNavController().navigate(R.id.action_SecondFragment_to_fourthFragment)
                Toast.makeText(requireContext(), "Logado com sucesso!", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Por favor preencha todos os campos!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun inputCheck(email : String, senha : String): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(senha))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}