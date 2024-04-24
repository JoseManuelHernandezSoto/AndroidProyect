package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        // Valor enviado con el intent
        val task: String = intent.extras?.getString("EXTRA_TASK_NAME").orEmpty()

        // Obtener el índice del elemento en la lista
        val index = TaskList.itemsDay.indexOf(task)

        // Obtener referencia al EditText y al botón de actualizar
        val etTask = findViewById<AppCompatEditText>(R.id.etTaskName)
        val btnActualizar = findViewById<AppCompatButton>(R.id.btnActualizar)

        // Establecer el texto del EditText con el valor del elemento
        etTask.setText(task)

        // Acción al hacer clic en el botón de actualizar
        btnActualizar.setOnClickListener {
            // Obtener la nueva tarea del EditText
            val newTask = etTask.text.toString()
            Log.d("Index Lista", "Índice de la lista: $task")
            Log.d("Index Lista", "Índice de la lista: $index")
            Log.d("Index Lista", "Reemplazo en la lista: $newTask")

            // Realizar el reemplazo en la lista
            TaskList.itemsDay[index] = newTask


            // Opcional: Notificar a la actividad anterior sobre el cambio
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}

