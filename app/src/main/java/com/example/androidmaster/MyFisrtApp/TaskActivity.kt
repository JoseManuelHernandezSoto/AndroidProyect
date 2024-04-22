package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmaster.R

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val tvTask = findViewById<AppCompatTextView>(R.id.activity)

        val btnEliminar = findViewById<AppCompatButton>(R.id.btnEliminar)
        val btnActividad = findViewById<AppCompatButton>(R.id.btnActualizar)

        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()

        tvTask.text = "$task"

        btnEliminar.setOnClickListener {

        }

        btnActividad.setOnClickListener {}






    }
}