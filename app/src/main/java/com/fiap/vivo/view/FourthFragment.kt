package com.fiap.vivo.view

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fiap.vivo.databinding.FragmentFourthBinding
import com.fiap.vivo.model.UserViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [FourthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentFourthBinding? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bringData()

        binding.dashboardButtonLogout.setOnClickListener {
            logout()
        }

    }

    private fun bringData(){
        var cnpjCpf = ""
        val identificacaoPersistencia = this.activity?.getSharedPreferences("identificacao", Context.MODE_PRIVATE)
        if (identificacaoPersistencia != null) {
            cnpjCpf = identificacaoPersistencia.getString("documento", "").toString()
        }
        binding.dashboardPageName.text = "Nome: " + mUserViewModel.findName(cnpjCpf)
        binding.dashboardPageCpfCnpj.text = "Cpf/Cnpj: " + mUserViewModel.findUser(cnpjCpf)
        binding.dashboardPageEmail.text = "Email: " + mUserViewModel.findEmailWithCpfCnpj(cnpjCpf)
        binding.dashboardPagePlan.text = "Plano: " + mUserViewModel.findPlanos(cnpjCpf)
        binding.dashboardPageSituation.text = "Situação: " + mUserViewModel.findSituacao(cnpjCpf).uppercase()
    }

    private fun logout() {
        R.attr.finishOnCloseSystemDialogs
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}