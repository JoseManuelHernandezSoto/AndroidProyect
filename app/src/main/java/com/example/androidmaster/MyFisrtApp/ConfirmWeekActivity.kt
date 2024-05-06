package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmaster.R

class ConfirmWeekActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_week)

        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val tvTaskName = findViewById<TextView>(R.id.tvTaskName)
        val tvTaskDescription = findViewById<TextView>(R.id.tvTaskDescription)
        val tvTaskDate = findViewById<TextView>(R.id.tvTaskDate)

        val name: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()
        val description: String = intent.extras?.getString("EXTRA_TASK_DESCRIPTION").orEmpty()
        val date: String = intent.extras?.getString("EXTRA_TASK_DATE").orEmpty()



        tvTaskName.text = "$name"
        tvTaskDescription.text = "$description"
        tvTaskDate.text = "$date"

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            Toast.makeText(this, "Tarea creada con exito", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}