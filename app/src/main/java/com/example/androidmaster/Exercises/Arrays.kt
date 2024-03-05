package com.example.androidmaster.Exercises

val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

fun main() {

    /**
     * Este FOR regresa el numero de la posicion del ARRAY
     */
    for (position in weekDays.indices) {

        println(weekDays[position])
    }
    println(" ")
    /**
     * Este FOR regresa el valor y la posicion del ARRAY
     */
    for ((position, value) in weekDays.withIndex()) {
        println("La posicion $position dice $value")
    }
    println("")
    /**
     * Este FOR solo regresa el valor del ARRAY
     */
    for (weekDay in weekDays) {
        println("Hoy es $weekDay")
    }


}
