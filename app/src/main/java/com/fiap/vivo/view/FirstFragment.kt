package com.fiap.vivo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.DatabaseManager
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

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cpfCnpj.addTextChangedListener(MaskUnmask.MaskEditUtil.mask(binding.cpfCnpj))
        binding.buttonFirst.setOnClickListener {

            val db = DatabaseManager(this, "BANCO")
            val valor = binding.cpfCnpj.text.toString()
            var cpfCnpj = ""
            var checkDB = false
            val cursor = db.findUser(valor)

            //db.insereUser(valor, valor)

            if (cursor.count > 0) {
                cursor.moveToFirst()
                cpfCnpj = cursor.getString(cursor.getColumnIndex("CPF_CNPJ"))
            }

            when (binding.cpfCnpj.text.length) {
                14 -> {
                    if (checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())) {
                        binding.docCheck.text = "CPF válido"
                        binding.docCheck.setTextColor(Color.GREEN)
                        //chamar metodo que verifica o banco
                        checkDB = true
                    } else {
                        binding.docCheck.text = "CPF inválido"
                        binding.docCheck.setTextColor(Color.RED)
                        checkDB = false
                    }
                }
                18 -> {
                    if (checkCpfCnpj.checkCpf(binding.cpfCnpj.text.toString())) {
                        binding.docCheck.text = "CNPJ válido"
                        binding.docCheck.setTextColor(Color.GREEN)
                        checkDB = true
                    } else {
                        binding.docCheck.text = "CNPJ inválido"
                        binding.docCheck.setTextColor(Color.RED)
                        checkDB = false
                    }
                }
                else -> {
                    binding.docCheck.text = "Não é um CPF nem CNPJ válido."
                    checkDB = false
                }
            }
            if (checkDB) {
                if (valor == cpfCnpj) {
                    sharedPreferrences()
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                } else {
                    sharedPreferrences()
                    findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment2)
                }
            }
        }
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}