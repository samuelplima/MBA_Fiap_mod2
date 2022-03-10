package com.fiap.vivo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.ChangePasswordScreenBinding
import com.fiap.vivo.util.CheckPasswords
import com.fiap.vivo.util.IdentificacaoPersistencia
import com.fiap.vivo.viewmodel.UserViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ChangePasswordScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChangePasswordScreen : Fragment() {

    private val identificacaoPersistencia = IdentificacaoPersistencia()
    private val checkPasswords = CheckPasswords()
    private lateinit var mUserViewModel: UserViewModel
    private var _binding: ChangePasswordScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = ChangePasswordScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cnpjCpf = identificacaoPersistencia.identificacaoPersistenciaPassword(
            binding,
            this.requireActivity()
        )

        binding.buttonSave.setOnClickListener {
            val password = binding.newPassword.text.toString()
            val password1 = binding.newPassword1.text.toString()

            if(checkPasswords.checkPasswords(password,password1)){
                mUserViewModel.changePassword(password, cnpjCpf )
                Toast.makeText(this.requireContext(), "Nova senha salva com sucesso!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_changePasswordScreen2_to_FirstFragment)
            } else {
                Toast.makeText(this.requireContext(), "Senhas não conferem!", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}