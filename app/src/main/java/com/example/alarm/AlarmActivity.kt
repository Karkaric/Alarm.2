package com.example.alarm

import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class AlarmActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.alarm)


    //  var  Uri =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
    // var ringtone = RingtoneManager.getRingtone(this, Uri)


    }

    override fun onDestroy() {
        var  Uri =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        var ringtone = RingtoneManager.getRingtone(this, Uri)
        if(ringtone.isPlaying){
            ringtone.stop()
        }
        super.onDestroy()
    }
}