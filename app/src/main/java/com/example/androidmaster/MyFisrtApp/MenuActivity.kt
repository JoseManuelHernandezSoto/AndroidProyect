package com.example.androidmaster.MyFisrtApp

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmaster.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imgAddToday = findViewById<ImageView>(R.id.imgAddToday)
        val imgAddWeek = findViewById<ImageView>(R.id.imgAddweek)

        val rbOptionToday1 = findViewById<RadioButton>(R.id.rbOptionToday1)
        val rbOptionToday2 = findViewById<RadioButton>(R.id.rbOptionToday2)
        val rbOptionToday3 = findViewById<RadioButton>(R.id.rbOptionToday3)
        val rbOptionToday4 = findViewById<RadioButton>(R.id.rbOptionToday4)

        val rbOptionWeek1 = findViewById<RadioButton>(R.id.rbOptionWeek1)
        val rbOptionWeek2 = findViewById<RadioButton>(R.id.rbOptionWeek2)
        val rbOptionWeek3 = findViewById<RadioButton>(R.id.rbOptionWeek3)
        val rbOptionWeek4 = findViewById<RadioButton>(R.id.rbOptionWeek4)
        val rbOptionWeek5 = findViewById<RadioButton>(R.id.rbOptionWeek5)

        imgAddToday.setOnClickListener {
            val intent = Intent(this, AddTodayActivity::class.java)
            startActivity(intent)
        }

        imgAddWeek.setOnClickListener {
            val intent = Intent(this, AddWeekActivity::class.java)
            startActivity(intent)
        }

        rbOptionToday1.setOnClickListener {
            rbOptionToday1.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionToday1.paintFlags = rbOptionToday1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionToday2.setOnClickListener {
            rbOptionToday2.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionToday2.paintFlags = rbOptionToday2.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionToday3.setOnClickListener {
            rbOptionToday3.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionToday3.paintFlags = rbOptionToday3.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionToday4.setOnClickListener {
            rbOptionToday4.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionToday4.paintFlags = rbOptionToday4.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionWeek1.setOnClickListener {
            rbOptionWeek1.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionWeek1.paintFlags = rbOptionWeek1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionWeek2.setOnClickListener {
            rbOptionWeek2.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionWeek2.paintFlags = rbOptionWeek2.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionWeek3.setOnClickListener {
            rbOptionWeek3.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionWeek3.paintFlags = rbOptionWeek3.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionWeek4.setOnClickListener {
            rbOptionWeek4.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionWeek4.paintFlags = rbOptionWeek4.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        rbOptionWeek5.setOnClickListener {
            rbOptionWeek5.setTextColor(resources.getColor(android.R.color.darker_gray))
            rbOptionWeek5.paintFlags = rbOptionWeek5.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

    }
}