package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R

class UpdateActivityWeek : AppCompatActivity() {
    private var selectedDate: String = "" // Variable para almacenar la fecha seleccionada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_week)

        val btnUpdate = findViewById<AppCompatButton>(R.id.btnConfirm)
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

        // Valor enviado con el intent
        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()
        val parts = task.split("-")
        // Obtener el índice del elemento en la lista
        val index = TaskList.itemsWeek.indexOf(task)

        // Establecer el texto del EditText con el valor del elemento
        etTaskName.setText(parts[0])

        btnUpdate.setOnClickListener {
            val newTask = etTaskName.text.toString()
            val selectedCategory = spCategoria.selectedItem.toString()
           // val newDescription = etTaskDescripcion.text.toString()
            // Realizar el reemplazo en la lista
            TaskList.itemsWeek[index] = "$newTask - $selectedCategory - $selectedDate"

            // Opcional: Notificar a la actividad anterior sobre el cambio
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
