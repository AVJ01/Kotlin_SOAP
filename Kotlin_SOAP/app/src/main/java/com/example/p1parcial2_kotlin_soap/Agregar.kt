package com.example.p1parcial2_kotlin_soap

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar.*

class Agregar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        BTNAgregar.setOnClickListener {
            val nombre = TXTNombre.text.toString().trim()
            val apPaterno = TXTapPaterno.text.toString().trim()
            val apMaterno = TXTapMaterno.text.toString().trim()
            val codigoAcceso = TXTcodigoAcceso.text.toString().trim()
            when {
                nombre.length == 0 || apPaterno.length == 0 || apMaterno.length == 0|| codigoAcceso.length == 0 -> Toast.makeText(
                    this,
                    "No puede aver un campo vacío",
                    Toast.LENGTH_SHORT
                ).show()
                !Utils.isConnected(this@Agregar) -> Toast.makeText(
                    this,
                    "No hubo internet",
                    Toast.LENGTH_SHORT
                ).show()
                else -> getCitiesOfCountry().execute(nombre,apPaterno,apMaterno,codigoAcceso)
            }
        }
    }
    inner class getCitiesOfCountry : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            val response = CallWebService().callCreate("1",params[0],
                params[1],params[2],params[3])//Construye el la petición
            Log.v("response", "response==" + response)
            return response //retorna el resultado
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                txtRPCreate.setText(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
