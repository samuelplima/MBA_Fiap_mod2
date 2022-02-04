package com.fiap.vivon

import org.junit.Assert.*

import org.junit.Test

class FirstFragmentTest {

    val firstFragment = FirstFragment()

    //teste função checkCpf
    @Test
    fun checkCpfTest() {
        assertEquals(true, firstFragment.checkCpf("39792784845"))
    }

    //teste função checkCnpj
    @Test
    fun checkCnpjTest() {
        assertEquals(false, firstFragment.checkCnpj("455555555555651223"))
    }
}