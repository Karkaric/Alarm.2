package com.example.alarm

import android.media.RingtoneManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class AlarmActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.alarm)
        val uriNotifcation = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone = RingtoneManager.getRingtone(this, uriNotifcation)
        if (ringtone!=null) ringtone.play()
    }

  /*  override fun onDestroy() {

        val uriNotifcation = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone = RingtoneManager.getRingtone(this, uriNotifcation)
        if (ringtone !=null && ringtone.isPlaying )ringtone.stop()
        super.onDestroy()
    }*/
}