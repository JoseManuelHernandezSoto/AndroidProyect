package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.androidmaster.R


class AddTodayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_today)

        val spCategoria: Spinner = findViewById(R.id.spCategoria)
        // Define las opciones a mostrar en el Spinner
        val opciones = arrayOf("Urgente", "No urgente", "Otro")

        // Configura un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        // Especifica el diseño para el menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asigna el adaptador al Spinner
        spCategoria.adapter = adapter

        val btnConfirm = findViewById<AppCompatButton>(R.id.btnConfirm)
        val etTaskName = findViewById<TextView>(R.id.etTaskName)
        val etTaskDescription = findViewById<TextView>(R.id.etTaskDescription)

        btnConfirm.setOnClickListener {
            val taskName = etTaskName.text.toString()
            val taskDescription = etTaskDescription.text.toString()

            // Obtener el elemento seleccionado del Spinner al hacer clic en el botón
            val selectedCategory = spCategoria.selectedItem.toString()

            // Agregar la tarea a la lista
            TaskList.itemsDay.add("$taskName - $selectedCategory")
            TaskList.descriptionDay.add(taskDescription)

            // Crear el intent y comenzar la ConfirmWeekActivity
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", taskName)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", taskDescription)
            Toast.makeText(this, "Tarea creada con exito", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
