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
            val intent = Intent(this, ConfirmWeekActivity::class.java)
            val taskNane = etTaskName.text.toString()
            val taskDescription = etTaskDescription.text.toString()

            intent.putExtra("EXTRA_TASK_NAME", taskNane)
            intent.putExtra("EXTRA_TASK_DESCRIPTION", taskDescription)
            startActivity(intent)
        }

    }
}