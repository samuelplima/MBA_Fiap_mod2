package com.fiap.testes

import com.fiap.vivo.util.InputCheck
import junit.framework.Assert.assertEquals
import org.junit.Test


class InputCheckTest {

    private val inputCheck = InputCheck()

    @Test
    fun inputCheckLoginTest() {
        assertEquals(true, inputCheck.inputCheckLogin("samuel@gmail.com", "1234"))
    }

    @Test
    fun inputCheckRegistrationTest() {
        assertEquals(
            true,
            inputCheck.inputCheckRegistration(
                "samuel@gmail.com",
                "397.927.848-45",
                "983852779",
                "samuel@gmailo.com",
                "empresarial",
                "1234"
            )
        )
    }


}