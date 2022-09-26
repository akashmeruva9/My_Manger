package com.akash.meruva.my_manger.Task

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.akash.meruva.my_manger.R
import kotlinx.android.synthetic.main.activity_update_task.*
import java.text.SimpleDateFormat
import java.util.*

class updatetask : AppCompatActivity() {

    var selecteddate1:  Int = 0
    var selectedmonth1: Int = 0
    var selectedyear1:  Int = 0
    var todaydate1:     Int = 0
    var todaymonth1:    Int = 0
    var todayyear1:     Int = 0


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_task)

        val reciever = intent.extras
        val id = reciever?.getInt("id")!!
        Tasktitledittext_update.append(reciever.getString("title").toString())
        taskdescriptionedittext_update.append(reciever.getString("description").toString())
        taskdateofsubmission_update.text = reciever.getString("duedate").toString()

        val submitteddate = reciever.getString("duedate").toString()
        val sdf1 = SimpleDateFormat("dd-MM-yyyy" , Locale.ENGLISH)
        val date1 = sdf1.parse(submitteddate)
        selecteddate1 = date1.date
        selectedmonth1 = date1.month
        selectedyear1 = date1.year

        val c = Calendar.getInstance()
        val cyear = c.get(Calendar.YEAR)
        val cmonth = c.get(Calendar.MONTH)
        val cday = c.get(Calendar.DAY_OF_MONTH)

        var tempdate = "$cday-$cmonth-$cyear"
        val sdf2 = SimpleDateFormat("dd-MM-yyyy" , Locale.ENGLISH)
        val date2 = sdf2.parse(tempdate)
        todaydate1 = date2.date
        todaymonth1 = date2.month+ 1
        todayyear1 = date2.year

        taskentryseekBar_update.progress = ((reciever.getInt("progress")).div(10))
        taskeditupdateprogress.text = "${reciever.getInt("progress")}%"


        taskeditupdate.setOnClickListener {
            check(id)
        }

        taskeditcancel.setOnClickListener {
            val resultIntent = Intent()
            setResult(RESULT_CANCELED, resultIntent)
            finish()
        }

        taskdateofsubmission_update.setOnClickListener {

            todaydate1 = cday
            todaymonth1 = cmonth +1
            todayyear1 = cyear

            DatePickerDialog(this, DatePickerDialog.OnDateSetListener
            { view, year, month, day ->

                taskdateofsubmission_update.text = null
                taskdateofsubmission_update.append("$day-${month + 1}-$year")
                selecteddate1 = day
                selectedmonth1 = month + 1
                selectedyear1 = year

            }, cyear, cmonth, cday
            ).show()
        }


        taskentryseekBar_update.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                taskeditupdateprogress.text = "${(taskentryseekBar_update.progress * 10)}%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun check(id : Int) {

        var a = true

        if (Tasktitledittext_update.text.isNullOrEmpty()) {
            Tasktitledittext_update.error = "Required"
            a = false
        }


        if (taskdateofsubmission_update.text.isNullOrEmpty()) {
            taskdateofsubmission_update.error = "Required"
            a = false
        }


        if (a == true) {

            val progress: Int = taskeditupdateprogress.text.toString().substringBefore("%").toInt()

            val resultIntentupdate = Intent()
            resultIntentupdate.putExtra("id" , id)
            resultIntentupdate.putExtra("title", Tasktitledittext_update.text.toString())
            resultIntentupdate.putExtra("description", taskdescriptionedittext_update.text.toString())
            resultIntentupdate.putExtra("date", taskdateofsubmission_update.text.toString())
            resultIntentupdate.putExtra("progress", progress)

            setResult(RESULT_OK, resultIntentupdate)
            finish()
        }
    }



}