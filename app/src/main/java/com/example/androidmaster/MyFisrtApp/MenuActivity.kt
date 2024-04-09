package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
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