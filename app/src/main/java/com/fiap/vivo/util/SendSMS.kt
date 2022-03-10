package com.fiap.vivo.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class SendSMS {

    fun SMS(activity:Activity, context: Context, phone: String, sms: String){
        if (checkSelfPermission(activity,
                Manifest.permission.SEND_SMS)
            != PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.SEND_SMS)) {
                Toast.makeText(context, "Precisa liberar permissao", Toast.LENGTH_LONG).show()
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity,
                    arrayOf(Manifest.permission.SEND_SMS), 1)
                //sendSMS(context, phone, sms)
            }
        } else {
            sendSMS(context, phone, sms)
        }
    }

    fun sendSMS(context: Context, phone: String, sms: String) : String{
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phone, null, sms, null, null)
        Toast.makeText(context, "Foi enviado um SMS ao numero cadastrado!", Toast.LENGTH_LONG).show()
        return sms
    }



}