package com.example.custom_date_picker

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var sDate : TextView
    lateinit var btnOpenDatePicker : Button
    private val calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sDate = findViewById<TextView>(R.id.selected_date)
        btnOpenDatePicker = findViewById<Button>(R.id.btnOpenDatePicker)

        btnOpenDatePicker.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker(){
        val datePickerDialog = DatePickerDialog(
            this,{DatePicker,year:Int,monthOfYear:Int,dayOfMonth:Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year,monthOfYear,dayOfMonth)
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                sDate.text = "Selected date: "+ formattedDate
                sDate.setTextColor(Color.parseColor("#5FB0E5"))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}