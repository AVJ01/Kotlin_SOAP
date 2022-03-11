package com.example.p1parcial2_kotlin_soap

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_eliminar.*

class Eliminar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)

        BTNDelete.setOnClickListener {
            val ID = TXTIDELIM.text.toString().trim()

            when {
                ID.length == 0 -> Toast.makeText(
                    this,
                    "No puede aver un campo vacío",
                    Toast.LENGTH_SHORT
                ).show()
                !Utils.isConnected(this@Eliminar) -> Toast.makeText(
                    this,
                    "No hubo internet",
                    Toast.LENGTH_SHORT
                ).show()
                else -> getCitiesOfCountry().execute(ID)
            }
        }


    }
    inner class getCitiesOfCountry : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            val response = CallWebService().callDelete(params[0])//Construye el la petición
            Log.v("response", "response==" + response)
            return response //retorna el resultado
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                txtRPDelete.setText(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
