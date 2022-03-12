package com.fiap.testes

import com.fiap.vivo.databinding.RecoverPasswordBinding
import com.fiap.vivo.util.BringData
import com.fiap.vivo.util.ValidateSMS
import org.junit.Assert
import org.junit.Test

class ValidateSMSTest {

    private val validateSMS = ValidateSMS()

    @Test
    fun validateSMSTest(){
        validateSMS.userCode = "1234"
        validateSMS.smsCode = "1234"
        Assert.assertEquals(true, validateSMS.validateSMS())
    }

}