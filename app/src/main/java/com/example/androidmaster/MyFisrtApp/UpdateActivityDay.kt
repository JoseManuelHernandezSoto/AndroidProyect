package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class UpdateActivityDay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_day)

        val spCategoria: Spinner = findViewById(R.id.spCategoria)
        // Define las opciones a mostrar en el Spinner
        val opciones = arrayOf("Urgente", "No urgente", "Otro")

        // Configura un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        // Especifica el diseño para el menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asigna el adaptador al Spinner
        spCategoria.adapter = adapter

        // Valor enviado con el intent
        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()
      //  val taskD: String = intent.extras?.getString("EXTRA_TASK_DESCRIPTION").orEmpty()


        val parts = task.split("-")
      //  val partsD = taskD.split(" ")

        // Obtener el índice del elemento en la lista
        val index = TaskList.itemsDay.indexOf(task)
      //  val indexD = TaskList.descriptionDay.indexOf(taskD)

        // Obtener referencia al EditText y al botón de actualizar
        val etTask = findViewById<TextInputEditText>(R.id.etTaskName)
        //val etTaskDescription = findViewById<TextInputEditText>(R.id.etTaskDescription)
        val btnActualizar = findViewById<AppCompatButton>(R.id.btnActualizar)

        // Establecer el texto del EditText con el valor del elemento
        etTask.setText(parts[0])
        //etTaskDescription.setText(partsD[0])



        // Acción al hacer clic en el botón de actualizar
        btnActualizar.setOnClickListener {
            // Obtener la nueva tarea del EditText
            val newTask = etTask.text.toString()
           // val newDesc = etTaskDescription.text.toString()
            // Obtener el valor seleccionado del Spinner
            val selectedCategory = spCategoria.selectedItem.toString()

            Log.d("Index Lista", "Índice de la lista: $task")
            Log.d("Index Lista", "Índice de la lista: $index")
            Log.d("Index Lista", "Reemplazo en la lista: $newTask")

            // Realizar el reemplazo en la lista
            TaskList.itemsDay[index] = "$newTask - $selectedCategory"
            //TaskList.descriptionDay[indexD] = "$newDesc "

            // Opcional: Notificar a la actividad anterior sobre el cambio
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
