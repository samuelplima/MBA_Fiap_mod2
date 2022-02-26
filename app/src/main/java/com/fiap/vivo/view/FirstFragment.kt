package com.fiap.vivo.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.FragmentFirstBinding
import com.fiap.vivo.model.UserViewModel
import com.fiap.vivo.presenter.CheckCpfCnpj
import com.fiap.vivo.presenter.MaskUnmask


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentFirstBinding? = null

    val checkCpfCnpj = CheckCpfCnpj()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cpfCnpj.addTextChangedListener(MaskUnmask.MaskEditUtil.mask(binding.cpfCnpj))
        binding.buttonFirst.setOnClickListener {


            var checkData: Boolean
            val cpfCnpjDB = binding.cpfCnpj.text.toString()
            val cpfCnpjUser = findUser(cpfCnpjDB)


            when (binding.cpfCnpj.text.length) {
                14 -> {
                    if (checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())) {
                        checkData = true
                    } else {
                        binding.docCheck.text = "CPF inválido"
                        binding.docCheck.setTextColor(Color.RED)
                        checkData = false
                    }
                }
                18 -> {
                    if (checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())) {
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
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                } else {
                    sharedPreferrences()
                    findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment2)
                }
            }
        }
    }

    fun sharedPreferrences(){
        val identificacaoPersistencia =
            this.activity?.getSharedPreferences(
                "identificacao",
                Context.MODE_PRIVATE
            )
        val editor = identificacaoPersistencia?.edit()
        if (editor != null) {
            editor.putString("documento", binding.cpfCnpj.text.toString())
            editor.apply()
        }
    }

    fun findUser(cpfCnpjDB : String) : String{
        return mUserViewModel.findUser(cpfCnpjDB)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}