package com.fiap.testes

import com.fiap.vivo.presenter.CheckCpfCnpj
import org.junit.Assert.*

import org.junit.Test

class CheckCpfCnpjTest {

    val checkCpfCnpj = CheckCpfCnpj()

    //teste função checkCpf
    @Test
    fun checkCpfTestOkay() {
        assertEquals(true, checkCpfCnpj.checkCpf("39792784845"))
    }
    @Test
    fun checkCpfTestNotOkay() {
        assertEquals(false, checkCpfCnpj.checkCpf("43141678819"))
    }

    //teste função checkCnpj
    @Test
    fun checkCnpjTestOkay() {
        assertEquals(true, checkCpfCnpj.checkCnpj("00811569000137"))
    }
    @Test
    fun checkCnpjTestNotOkay() {
        assertEquals(false, checkCpfCnpj.checkCnpj("455555555555651223"))
    }
}