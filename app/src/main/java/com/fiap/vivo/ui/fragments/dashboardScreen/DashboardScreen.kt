package com.fiap.vivo.ui.fragments.dashboardScreen

import android.Manifest
import android.R
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.databinding.DashboardScreenBinding
import com.fiap.vivo.util.BringData
import com.fiap.vivo.util.IdentificacaoPersistencia
import com.fiap.vivo.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardScreen : Fragment() {

    private val identificacaoPersistencia = IdentificacaoPersistencia()

    private val bringData = BringData()

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: DashboardScreenBinding? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        _binding = DashboardScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val cnpjCpf = identificacaoPersistencia.identificacaoPersistenciaDashboard(
            binding,
            this.requireActivity()
        )
        bringData.bringData(cnpjCpf, binding, mUserViewModel)

        binding.dashboardButtonLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        R.attr.finishOnCloseSystemDialogs
        findNavController().navigate(com.fiap.vivo.R.id.action_fourthFragment_to_FirstFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}