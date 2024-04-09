package com.example.androidmaster.MyFisrtApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidmaster.R

class AddWeekActivity : AppCompatActivity() {
    companion object {
        val itemsWeek: MutableList<String> = mutableListOf()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_week)

        val btnConfirm = findViewById<AppCompatButton>(R.id.btnConfirm)
        val calendarWeek = findViewById<CalendarView>(R.id.calendarToday)
        val etTaskName = findViewById<AppCompatEditText>(R.id.etTaskName)
        val etTaskDescripcion = findViewById<AppCompatEditText>(R.id.etTaskDescription)

        btnConfirm.setOnClickListener {
            itemsWeek.add(etTaskName.text.toString())
            val intent = Intent(this, ConfirmWeekActivity::class.java)
            calendarWeek.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val monthCorrect = month + 1
                val date = ("$dayOfMonth/$monthCorrect/$year").toString()

                intent.putExtra("EXTRA_TASK_DATE", date)
            }
            val taskNane = etTaskName.text.toString()
            val taskDescription = etTaskDescripcion.text.toString()

            intent.putExtra("EXTRA_TASK_NAME", taskNane)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", taskDescription)
            startActivity(intent)
        }

    }
}