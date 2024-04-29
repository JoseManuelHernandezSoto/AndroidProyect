package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.androidmaster.R


class AddTodayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_today)

        val btnConfirm = findViewById<AppCompatButton>(R.id.btnConfirm)
        val etTaskName = findViewById<TextView>(R.id.etTaskName)
        val etTaskDescription = findViewById<TextView>(R.id.etTaskDescription)

        btnConfirm.setOnClickListener {
            val taskName = etTaskName.text.toString()
            val taskDescription = etTaskDescription.text.toString()

            // Agregar la tarea a la lista
            TaskList.itemsDay.add(taskName)
            TaskList.descriptionDay.add(taskDescription)

            // Crear el intent y comenzar la ConfirmWeekActivity
            val intent = Intent(this, ConfirmWeekActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", taskName)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", taskDescription)
            startActivity(intent)
        }


    }
}