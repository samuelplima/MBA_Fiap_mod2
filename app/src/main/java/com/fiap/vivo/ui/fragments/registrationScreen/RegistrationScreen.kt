package com.fiap.vivo.ui.fragments.registrationScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.RegistrationScreenBinding
import com.fiap.vivo.util.EmailValidation
import com.fiap.vivo.util.IdentificacaoPersistencia
import com.fiap.vivo.util.InsertDataToDatabase
import com.fiap.vivo.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationScreen : Fragment() {

    private val insertDataToDatabase = InsertDataToDatabase()
    private val identificacaoPersistencia = IdentificacaoPersistencia()
    private lateinit var mUserViewModel: UserViewModel
    private var _binding: RegistrationScreenBinding? = null
    private val binding get() = _binding!!
    private val emailValidation = EmailValidation()

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

        identificacaoPersistencia.identificacaoPersistenciaRegistration(binding, this.requireActivity())

        binding.registrationButtonSave.setOnClickListener {
            if (!emailValidation.isValidEmail(binding.registrationEmailField.text.toString())) {
                binding.registrationEmailField.setBackground(getResources().getDrawable(R.drawable.error_text_background, null))
            }
            insertDataToDatabase.insertDataToDatabase(binding, this.requireActivity(), mUserViewModel, this.requireContext(), findNavController())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

