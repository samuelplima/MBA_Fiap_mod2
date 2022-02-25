package com.fiap.vivo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.R
import com.fiap.vivo.databinding.FragmentSecondBinding
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
        binding.textView2.text = mUserViewModel.findName(cnpjCpf)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}