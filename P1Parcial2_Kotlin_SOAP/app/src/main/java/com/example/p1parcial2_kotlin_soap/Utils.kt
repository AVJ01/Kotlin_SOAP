package com.example.p1parcial2_kotlin_soap

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
//
class Utils {
    companion object {
        val SOAP_URL = "http://  ip:puerto /WS_SOAP_WITH_MySQL/WSBDSOA?WSDL"
        val SOAP_NAMESPACE = "http://pksWS/"
        @SuppressLint("ServiceCast")
        fun isConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}