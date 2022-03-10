package com.fiap.vivo.ui.fragments.recoverPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.LoginScreenBinding
import com.fiap.vivo.databinding.RecoverPasswordBinding
import com.fiap.vivo.util.GenerateSmsCode
import com.fiap.vivo.util.IdentificacaoPersistencia
import com.fiap.vivo.util.SendSMS
import com.fiap.vivo.util.ValidateSMS
import com.fiap.vivo.viewmodel.UserViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [RecoverPassword.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecoverPassword : Fragment() {

    private val validateSMS = ValidateSMS()
    private val generateSmsCode = GenerateSmsCode()
    private val identificacaoPersistencia = IdentificacaoPersistencia()
    private val sendSMS = SendSMS()
    private lateinit var mUserViewModel: UserViewModel
    private var _binding: RecoverPasswordBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        _binding = RecoverPasswordBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cnpjCpf = identificacaoPersistencia.identificacaoPersistenciaRecover(
            binding,
            this.requireActivity()
        )
        val smsCode = generateSmsCode.code


        binding.registrationReSend.setOnClickListener {
            sendSMS.SMS(this.requireActivity(), this.requireContext(), mUserViewModel.findTelefone(cnpjCpf), smsCode)
        }

        binding.registrationConfirm.setOnClickListener{
            if(validateSMS.validateSMS(binding)){
                Toast.makeText(this.requireContext(), "Correto", Toast.LENGTH_LONG).show()
            } else{
                Toast.makeText(this.requireContext(), "Errado", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}