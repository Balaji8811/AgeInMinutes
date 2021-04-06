package com.example.ageapp

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datebtn.setOnClickListener{view ->
            clickDatePicker(view) }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view: View)
    {  var cal = Calendar.getInstance()
        var year = cal.get(Calendar.YEAR)
        var month = cal.get(Calendar.MONTH)
        var day = cal.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{
            view, Syear, Smonth, SdayOfMonth ->
            val selecd = "$SdayOfMonth/${Smonth+1}/$Syear"

            selectdate.setText(selecd)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selecd)

           val seldate = theDate!!.time / 60000

            val sinm = sdf.parse(sdf.format(System.currentTimeMillis()))

            val sinmin = sinm!!.time / 60000
             val diff = sinmin - seldate
            ageinmin.setText(diff.toString())
        }
        ,year
        ,month
        ,day
        ).show()
        Toast.makeText(this,"Button Works",Toast.LENGTH_LONG).show()
    }




}