package com.example.alarm
import android.app.PendingIntent
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.alarm.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class MainActivity : AppCompatActivity() {
    lateinit var Main: ActivityMainBinding
    private lateinit var alarmIntent: PendingIntent
    private val calendar = Calendar.getInstance()
    private var launcher:ActivityResultLauncher<Intent>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Main.root)
        val button = Main.bAlarm

     //  val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
     //  val alarmIntent= (AlarmActivity::class.java)
      //  val alarmClockInfo = (calendar.timeInMillis) as AlarmClockInfo




        button.setOnClickListener {
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(13)
                .setTitleText("Выберите Время ")
                .build()
            picker.show(supportFragmentManager,"ede")
         //   launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}



        }

    }
}




