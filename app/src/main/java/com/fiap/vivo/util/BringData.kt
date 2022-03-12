package com.fiap.vivo.util

import com.fiap.vivo.databinding.DashboardScreenBinding
import com.fiap.vivo.viewmodel.UserViewModel

class BringData {

    fun bringData(cnpjCpf: String, binding: DashboardScreenBinding, userViewModel: UserViewModel) {
        binding.dashboardPageName.text = "Nome: " + userViewModel.findName(cnpjCpf)
        binding.dashboardPageCpfCnpj.text = "Cpf/Cnpj: " + userViewModel.findUser(cnpjCpf)
        binding.dashboardPageTelefone.text = "Telefone: " + userViewModel.findTelefone(cnpjCpf)
        binding.dashboardPageEmail.text = "Email: " + userViewModel.findEmailWithCpfCnpj(cnpjCpf)
        binding.dashboardPagePlan.text = "Plano: " + userViewModel.findPlanos(cnpjCpf)
        binding.dashboardPageSituation.text = "Situação: " + userViewModel.findSituacao(cnpjCpf).uppercase()
    }

}