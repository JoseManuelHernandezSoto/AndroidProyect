package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //val etUser = findViewById<AppCompatEditText>(R.id.etUser)
        //val etPass = findViewById<AppCompatEditText>(R.id.etPassword)
        // val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val etUser = findViewById<TextInputEditText>(R.id.etUser)
        val etPass = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val userName = etUser.text.toString()
            val userPass = etPass.text.toString()
            if (userName.isNotEmpty() && userPass.isNotEmpty()) {
                //Comparacion de credenciales de acceso

                if (userName.equals("master") && userPass.equals("admin")) {
                    //Manda a la siguiene ventana
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else if (userName.equals("usuario") && userPass.equals("123")) {
                    val intent = Intent(this, MainUserActivity::class.java)
                    startActivity(intent)
                } else {
                    //Datos de acceso incorrectos
                    Toast.makeText(this, "Datos de acceso incorrectos", Toast.LENGTH_SHORT).show()
                }
            } else {
                //Mensaje para cuando no tenga datos
                Toast.makeText(this, "Porfavor llenar los campos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}