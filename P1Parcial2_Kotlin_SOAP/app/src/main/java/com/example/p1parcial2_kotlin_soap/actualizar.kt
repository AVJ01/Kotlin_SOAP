package com.example.p1parcial2_kotlin_soap

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*

class actualizar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        BTNActualizar.setOnClickListener {
            val ID = TXTIDACTU.text.toString().trim()
            val nombre = TXTNombreACTU.text.toString().trim()
            val apPaterno = TXTapPaternoACTU.text.toString().trim()
            val apMaterno = TXTapMaternoACTU.text.toString().trim()
            val codigoAcceso = TXTcodigoAccesoACTU.text.toString().trim()
            when {
                ID.length == 0 || nombre.length == 0 || apPaterno.length == 0 || apMaterno.length == 0|| codigoAcceso.length == 0 -> Toast.makeText(
                    this,
                    "No puede aver un campo vacío",
                    Toast.LENGTH_SHORT
                ).show()
                !Utils.isConnected(this@actualizar) -> Toast.makeText(
                    this,
                    "No hubo internet",
                    Toast.LENGTH_SHORT
                ).show()
                else -> getCitiesOfCountry().execute(ID,nombre,apPaterno,apMaterno,codigoAcceso)
            }
        }
    }
    inner class getCitiesOfCountry : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            val response = CallWebService().callUpdate(params[0],
                params[1],params[2],params[3],params[4])//Construye el la petición
            Log.v("response", "response==" + response)
            return response //retorna el resultado
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                txtRPUpdate.setText(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
