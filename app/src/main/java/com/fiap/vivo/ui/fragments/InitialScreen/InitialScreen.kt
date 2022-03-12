package com.fiap.vivo.ui.fragments.InitialScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fiap.vivo.databinding.InitialScreenBinding
import com.fiap.vivo.util.CheckData
import com.fiap.vivo.util.MaskUnmask
import com.fiap.vivo.viewmodel.UserViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InitialScreen : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: InitialScreenBinding? = null

    private val checkData = CheckData()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val database = mUserViewModel.readAllData()

        if (database.isEmpty()) {
            mUserViewModel.populateDB()
        }

        _binding = InitialScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.requireCpfCnpjField.addTextChangedListener(MaskUnmask.MaskEditUtil.mask(binding.requireCpfCnpjField))
        binding.searchLoginButton.setOnClickListener {

            val cpfCnpjDB = binding.requireCpfCnpjField.text.toString()
            val cpfCnpjUser = findUser(cpfCnpjDB)

            checkData.checkData(
                binding,
                cpfCnpjUser,
                cpfCnpjDB,
                findNavController(),
                this.requireActivity()
            )
        }
    }

    fun findUser(cpfCnpjDB: String): String {
        return mUserViewModel.findUser(cpfCnpjDB)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}