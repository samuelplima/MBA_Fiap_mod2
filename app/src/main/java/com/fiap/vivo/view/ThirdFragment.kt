package com.fiap.vivo.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.FragmentSecondBinding
import com.fiap.vivo.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val identificacaoPersistencia =
            this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)

        if (identificacaoPersistencia != null) {
            binding.textView3.text = identificacaoPersistencia.getString("documento", "")
            binding.textView4.text = "Nao tem cadastro, Cadastra-se!"
        }


        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment2_to_FirstFragment)
        }
    }

}

