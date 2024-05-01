package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmaster.R

class TaskActivityWeek : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_week)

        val tvTask = findViewById<AppCompatTextView>(R.id.activity)
        val tvdescr = findViewById<AppCompatTextView>(R.id.descrip)
        val btnEliminar = findViewById<AppCompatButton>(R.id.btnEliminar)
        val btnActividad = findViewById<AppCompatButton>(R.id.btnActualizar)

        val taskName = intent.getStringExtra("EXTRA_TASK_NAME").orEmpty()
        val taskDescription = intent.getStringExtra("EXTRA_TASK_DESCRIPTION").orEmpty()

        tvTask.text = taskName
        tvdescr.text = taskDescription

        btnEliminar.setOnClickListener {
            TaskList.itemsWeek.removeIf { it == tvTask.text.toString() }
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btnActividad.setOnClickListener {
            val intent = Intent(this, UpdateActivityWeek::class.java)
            intent.putExtra("EXTRA_TASK_NAME", taskName)
            startActivity(intent)
        }
    }
}