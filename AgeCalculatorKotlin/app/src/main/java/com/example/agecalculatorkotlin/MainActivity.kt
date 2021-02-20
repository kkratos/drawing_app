package com.example.agecalculatorkotlin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDataPicker.setOnClickListener { view ->
            clickDatePicker(view)
//            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }
    }


    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "The chosen year is $SelectedYear, the month is ${SelectedMonth + 1} and day is $SelectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()

                val selectedDate = "$SelectedDayOfMonth/${SelectedMonth + 1}/$SelectedYear"
                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinute = theDate!!.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateToMinutes = currentDate!!.time / 60000

                val differenceInMinutes = currentDateToMinutes - selectedDateInMinute

                val inDay: Double = (differenceInMinutes * 0.000694444) / 365

                tvSelectedDateInMinute.setText(inDay.toString())
            },
            year,
            month,
            day
        ).show()

    }
}