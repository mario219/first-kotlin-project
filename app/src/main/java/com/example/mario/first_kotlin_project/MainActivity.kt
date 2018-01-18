package com.example.mario.first_kotlin_project

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startAlert(view: View?){
        val etTime = findViewById<EditText>(R.id.time)
        val i: Int = Integer.getInteger(etTime.text.toString())
        val intent = Intent(this, MyBroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 234324243, intent,0)
        val alarmManager: AlarmManager = this.getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000), pendingIntent )
        Toast.makeText(this, "Alarm set in " + i + "seconds", Toast.LENGTH_SHORT).show()
    }

}
