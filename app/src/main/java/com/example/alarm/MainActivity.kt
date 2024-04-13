package com.example.alarm
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.AlarmManager.AlarmClockInfo
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alarm.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class MainActivity : AppCompatActivity() {
    lateinit var Main: ActivityMainBinding
    @SuppressLint("ScheduleExactAlarm", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Main.root)
        val button = Main.bAlarm



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


                val alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val alarmClockInfo =AlarmClockInfo(calendar.timeInMillis,PendingIntent_AlarmInfo())
                alarmManager.setAlarmClock(alarmClockInfo,PendingIntent_ActionPending())

                Toast.makeText(this,"Будильник Установлин ",Toast.LENGTH_LONG ).show()
            }


            picker.show(supportFragmentManager, "ede")
        }


    }
    private fun   PendingIntent_AlarmInfo():PendingIntent  {
        val alarmInfoIntent = Intent(this,MainActivity ::class.java)
        alarmInfoIntent.flags =Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        return PendingIntent.getActivity(this,1,alarmInfoIntent, PendingIntent.FLAG_MUTABLE)
    }
    private fun PendingIntent_ActionPending():PendingIntent {
        val intent = Intent(this,AlarmActivity::class.java)
        intent.flags =(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        return PendingIntent.getActivities(this ,2 , arrayOf(intent), PendingIntent.FLAG_MUTABLE)
    }
}



