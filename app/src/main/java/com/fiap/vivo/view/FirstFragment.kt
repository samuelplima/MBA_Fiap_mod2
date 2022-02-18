package com.fiap.vivo.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.FragmentFirstBinding
import com.fiap.vivo.presenter.CheckCpfCnpj
import com.fiap.vivo.presenter.MaskUnmask


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    val checkCpfCnpj = CheckCpfCnpj()

    val maskUnmask = MaskUnmask()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cpfCnpj.addTextChangedListener(MaskUnmask.MaskEditUtil.mask(binding.cpfCnpj))
            binding.buttonFirst.setOnClickListener {
                    when(binding.cpfCnpj.text.length){
                        14 -> {
                            if (checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())) {
                                //  binding.docCheck.text = "CPF válido"
                                //  binding.docCheck.setTextColor(Color.GREEN)
                                //chamar metodo que verifica o banco

                                val identificacaoPersistencia =
                                    this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
                                val editor = identificacaoPersistencia?.edit()
                                if (editor != null) {
                                    editor.putString("documento", binding.cpfCnpj.text.toString())
                                    editor.apply()
                                }
                                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

                            } else {
                                binding.docCheck.text = "CPF inválido"
                                binding.docCheck.setTextColor(Color.RED)
                            }
                        }
                        18 -> {
                            if(checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())){
                                binding.docCheck.text = "CNPJ válido"
                                binding.docCheck.setTextColor(Color.GREEN)
                            }
                            else{
                                binding.docCheck.text = "CNPJ inválido"
                                binding.docCheck.setTextColor(Color.RED)
                            }
                        }
                        else -> {
                            binding.docCheck.text = "Não é um CPF nem CNPJ válido."
                        }
                    }
                }
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}