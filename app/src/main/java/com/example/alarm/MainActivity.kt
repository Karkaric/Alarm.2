package com.example.alarm
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.AlarmManager.AlarmClockInfo
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alarm.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class MainActivity : AppCompatActivity() {
    lateinit var Main: ActivityMainBinding

    val alarmIntent = "com.example.alarm.ACTION"

    @SuppressLint("ScheduleExactAlarm", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Main.root)
        val button = Main.bAlarm

        // Create and register the BroadcastReceiver
        val alarmReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                //TODO:: тут можно делать какие угодно действия, которые ты хочешь запустить по аларму
                print("")
            }
        }
        registerReceiver(alarmReceiver, IntentFilter(alarmIntent))

        button.setOnClickListener {

            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(13)
                .setTitleText("Выберите Время ")
                .build()
            picker.addOnPositiveButtonClickListener {
                val calendar:Calendar = Calendar.getInstance()
                calendar.set(Calendar.SECOND,0)
                calendar.set(Calendar.MILLISECOND,0)
                calendar.set(Calendar.MINUTE ,picker.minute)
                calendar.set(Calendar.HOUR_OF_DAY ,picker.hour)

                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val intent = Intent(alarmIntent)
                val actionPendingIntent = PendingIntent.getBroadcast(
                    this@MainActivity,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )

                val alarmClockInfo = AlarmManager.AlarmClockInfo(calendar.timeInMillis, actionPendingIntent)
                alarmManager.setAlarmClock(alarmClockInfo, actionPendingIntent)

                Toast.makeText(this,"Будильник Установлин ",Toast.LENGTH_LONG ).show()
            }

            picker.show(supportFragmentManager, "ede")
        }
    }
}



