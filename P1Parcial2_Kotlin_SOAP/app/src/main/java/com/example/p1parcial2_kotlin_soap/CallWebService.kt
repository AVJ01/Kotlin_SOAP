package com.example.p1parcial2_kotlin_soap

import android.util.Log
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
class CallWebService {


    fun callCreate(id: String?, nombre: String?, apPaterno: String?, apMaterno: String?, codigoAcceso: String?): String {
        var result = ""
        val SOAP_ACTION = "http://pkgWS/Create"
        val methodName = "Create"
        val soapObject = SoapObject(Utils.SOAP_NAMESPACE, methodName)
        soapObject.addProperty("id", id)
        soapObject.addProperty("nombre", nombre)
        soapObject.addProperty("apPaterno", apPaterno)
        soapObject.addProperty("apMaterno", apMaterno)
        soapObject.addProperty("codigoAcceso", codigoAcceso)
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = false //Esto va a false cuando el servicio es de Java y true a .net
        val httpTransportSE = HttpTransportSE(Utils.SOAP_URL)
        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val soapPrimitive = envelope.response
            result = soapPrimitive.toString()
            Log.v("response", result)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    fun callUpdate(id: String?, nombre: String?, apPaterno: String?, apMaterno: String?, codigoAcceso: String?): String {
        var result = ""
        val SOAP_ACTION = "http://pkgWS/Update"
        val methodName = "Update"

        val soapObject = SoapObject(Utils.SOAP_NAMESPACE, methodName)
        soapObject.addProperty("id", id)
        soapObject.addProperty("nombre", nombre)
        soapObject.addProperty("apPaterno", apPaterno)
        soapObject.addProperty("apMaterno", apMaterno)
        soapObject.addProperty("codigoAcceso", codigoAcceso)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = false //Esto va a false cuando el servicio es de Java y true a .net
        val httpTransportSE = HttpTransportSE(Utils.SOAP_URL)
        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val soapPrimitive = envelope.response
            result = soapPrimitive.toString()
            Log.v("response", result)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    fun callDelete(input1: String?): String {
        var result = ""
        val SOAP_ACTION = "http://pkgWS/Delete"
        val methodName = "Delete"

        val soapObject = SoapObject(Utils.SOAP_NAMESPACE, methodName)
        soapObject.addProperty("id", input1)


        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = false //Esto va a false cuando el servicio es de Java y true a .net
        val httpTransportSE = HttpTransportSE(Utils.SOAP_URL)
        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val soapPrimitive = envelope.response
            result = soapPrimitive.toString()
            Log.v("response", result)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }
}