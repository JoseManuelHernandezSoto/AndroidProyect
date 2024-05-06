package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmaster.R

class TaskActivity : AppCompatActivity() {
    companion object {
        var itemsDay: MutableList<String> = mutableListOf()
        var itemsWeek: MutableList<String> = mutableListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val tvTask = findViewById<AppCompatTextView>(R.id.activity)
        val tvdescr = findViewById<AppCompatTextView>(R.id.descrip)
        val btnEliminar = findViewById<AppCompatButton>(R.id.btnEliminar)
        val btnActividad = findViewById<AppCompatButton>(R.id.btnActualizar)
        val btnRegresar = findViewById<Button>(R.id.btnBack)

        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()
        val desc: String = intent.extras?.getString("EXTRA_TASK_DESCRIPTION").orEmpty()

        tvTask.text = task
        tvdescr.text = desc

        btnEliminar.setOnClickListener {
            TaskList.itemsDay.removeIf { it == tvTask.text.toString() }
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        btnActividad.setOnClickListener {
            val task2 = tvTask.text.toString()
            val intent = Intent(this, UpdateActivityDay::class.java)
            intent.putExtra("EXTRA_TASK_NAME", task2)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}