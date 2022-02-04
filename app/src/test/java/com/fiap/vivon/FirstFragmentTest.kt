package com.fiap.vivon

import org.junit.Assert.*

import org.junit.Test

class FirstFragmentTest {

    val firstFragment = FirstFragment()

    //teste função checkCpf
    @Test
    fun checkCpfTestOkay() {
        assertEquals(true, firstFragment.checkCpf("39792784845"))
    }
    @Test
    fun checkCpfTestNotOkay() {
        assertEquals(false, firstFragment.checkCpf("43141678819"))
    }

    //teste função checkCnpj
    @Test
    fun checkCnpjTestOkay() {
        assertEquals(true, firstFragment.checkCnpj("00811569000137"))
    }
    @Test
    fun checkCnpjTestNotOkay() {
        assertEquals(false, firstFragment.checkCnpj("455555555555651223"))
    }
}