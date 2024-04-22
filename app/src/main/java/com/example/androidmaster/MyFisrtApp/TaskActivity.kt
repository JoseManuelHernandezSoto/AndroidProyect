package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmaster.R

class TaskActivity : AppCompatActivity() {
    companion object {
        var itemsDay: MutableList<String> = mutableListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val tvTask = findViewById<AppCompatTextView>(R.id.activity)
        val btnEliminar = findViewById<AppCompatButton>(R.id.btnEliminar)
        val btnActividad = findViewById<AppCompatButton>(R.id.btnActualizar)

        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()

        tvTask.text = task

        btnEliminar.setOnClickListener {
            TaskList.itemsDay.removeIf { it == tvTask.text.toString() }
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        btnActividad.setOnClickListener {
            //Agregar la logica
        }
    }
}