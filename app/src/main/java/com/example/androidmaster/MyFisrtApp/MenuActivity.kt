package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmaster.R

object TaskList {
    var itemsDay: MutableList<String> = mutableListOf()
    var descriptionDay: MutableList<String> = mutableListOf()
    var itemsWeek: MutableList<String> = mutableListOf()
    var descriptionweek: MutableList<String> = mutableListOf()
}
class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imgAddToday = findViewById<ImageView>(R.id.imgAddToday)
        val imgAddWeek = findViewById<ImageView>(R.id.imgAddweek)

        val listWeek = findViewById<ListView>(R.id.listWeek)
        val listDay = findViewById<ListView>(R.id.listDay)

        // Asignar la lista itemsDay del objeto TaskList al listDay
        listDay.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, TaskList.itemsDay)
        listWeek.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, TaskList.itemsWeek)

    /*    listDay.setOnItemClickListener { parent, view, position, id ->
            // Acción a realizar cuando se hace clic en un elemento del ListView
            val selectedItem = TaskList.itemsDay[position]
            Log.d("MiTag", "Elemento seleccionado: $selectedItem")
            val intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", selectedItem)
            startActivity(intent)
        }*/

        listDay.setOnItemClickListener { parent, view, position, id ->
            // Acción a realizar cuando se hace clic en un elemento del ListView
            val selectedName = TaskList.itemsDay[position] // Obtener el nombre de la tarea seleccionada
            val selectedDescription = TaskList.descriptionDay[position] // Obtener la descripción de la tarea seleccionada

            Log.d("MiTag", "Elemento seleccionado - Nombre: $selectedName, Descripción: $selectedDescription")

            val intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", selectedName)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", selectedDescription)
            startActivity(intent)
        }

  /*      listWeek.setOnItemClickListener { parent, view, position, id ->
            // Acción a realizar cuando se hace clic en un elemento del ListView
            val selectedName = TaskList.itemsWeek[position] // Obtener el nombre de la tarea seleccionada
            val selectedDescription = TaskList.descriptionweek[position] // Obtener la descripción de la tarea seleccionada

            Log.d("MiTag", "Elemento seleccionado - Nombre: $selectedName, Descripción: $selectedDescription")

            val intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", selectedName)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", selectedDescription)
            startActivity(intent)
        }*/

        imgAddToday.setOnClickListener {
            val intent = Intent(this, AddTodayActivity::class.java)
            startActivity(intent)
        }

        imgAddWeek.setOnClickListener {
            val intent = Intent(this, AddWeekActivity::class.java)
            startActivity(intent)
        }


    }
}