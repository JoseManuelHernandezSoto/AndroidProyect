package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R


class AddWeekActivity : AppCompatActivity() {

    private var selectedDate: String = "" // Variable para almacenar la fecha seleccionada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_week)

        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        val calendarWeek = findViewById<CalendarView>(R.id.calendarToday)
        val etTaskName = findViewById<AppCompatEditText>(R.id.etTaskName)
        val etTaskDescripcion = findViewById<AppCompatEditText>(R.id.etTaskDescription)
        val spCategoria: Spinner = findViewById(R.id.spCategoria)

        // Define las opciones a mostrar en el Spinner
        val opciones = arrayOf("Urgente", "No urgente", "Otro")

        // Configura un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        // Especifica el diseño para el menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asigna el adaptador al Spinner
        spCategoria.adapter = adapter

        // Configurar el listener para el CalendarView
        calendarWeek.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Formatea la fecha seleccionada
            selectedDate = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year)
            // Aquí puedes realizar cualquier otra acción con la fecha seleccionada
        }

        // Acción al hacer clic en el botón de confirmación
        btnConfirm.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            val taskDescription = etTaskDescripcion.text.toString()
            val taskName = etTaskName.text.toString()
            val selectedCategory = spCategoria.selectedItem.toString()

            // Agregar la tarea a la lista
            TaskList.itemsWeek.add("$taskName - $selectedCategory - $selectedDate")
            TaskList.descriptionweek.add(taskDescription)

            Toast.makeText(this, "Tarea creada con exito", Toast.LENGTH_SHORT).show()

            // Iniciar la actividad de confirmación
            startActivity(intent)
        }
    }
}

