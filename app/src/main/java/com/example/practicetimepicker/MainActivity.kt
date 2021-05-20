package com.example.practicetimepicker

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicetimepicker.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitle("Select Appointment time")
                .build()

        binding.button.setOnClickListener {

            picker.show(fragmentManager, "tag");

            picker.addOnPositiveButtonClickListener {
                val newHour: Int = picker.hour
                val newMinute: Int = picker.minute

                binding.button.text = newHour.toString() + newMinute.toString()
            }
        }
//            val cal = Calendar.getInstance()
//
//            // 시간을 선택했을 경우 일어나는 일
//            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
//                cal.set(Calendar.HOUR_OF_DAY, hour)
//                cal.set(Calendar.MINUTE, minute)
//
//                binding.button.text = SimpleDateFormat("HH:mm").format(cal.time)
//            }
//
//            TimePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
//        }

    }
}