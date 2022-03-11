package com.example.p1parcial2_kotlin_soap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPTCreate.setOnClickListener {
            val intent = Intent(this, Agregar::class.java)
            startActivity(intent)
        }
        btnPTUpdate.setOnClickListener {
            val intent = Intent(this, actualizar::class.java)
            startActivity(intent)
        }
        btnPTDelete.setOnClickListener {
            val intent = Intent(this, Eliminar::class.java)
            startActivity(intent)
        }
    }

}
