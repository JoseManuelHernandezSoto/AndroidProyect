package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.graphics.Paint


import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmaster.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imgAddToday = findViewById<ImageView>(R.id.imgAddToday)
        val imgAddWeek = findViewById<ImageView>(R.id.imgAddweek)

        val listWeek = findViewById<ListView>(R.id.listWeek)
        val listDay = findViewById<ListView>(R.id.listDay)

        val itemsDay = AddTodayActivity.itemsDay
        val itemsWeek = AddWeekActivity.itemsWeek

        val adapterDay = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsDay)
        val adapterWeek = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsWeek)

        // Asignar el adaptador a la lista del día
        listDay.adapter = adapterDay
        listWeek.adapter = adapterWeek

        listDay.setOnItemClickListener { parent, view, position, id ->
            // Acción a realizar cuando se hace clic en un elemento del ListView
            val selectedItem = itemsDay[position]
            Log.d("MiTag", "Elemento seleccionado: $selectedItem")
            val intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("EXTRA_TASK_NAME", selectedItem)
            startActivity(intent)
        }


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