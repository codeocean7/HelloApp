package com.zealsoft.helloapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class NotiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_layout)

        val btnNoti=findViewById<Button>(R.id.btnShowNoti)

        btnNoti.setOnClickListener {

            val mBuilder = NotificationCompat.Builder(this, "CH_ID")

              val homeIntent = Intent(this, HomeActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, homeIntent, 0)

            mBuilder.setSmallIcon(R.drawable.ic_botify)
            mBuilder.setContentTitle("Your Title")
            mBuilder.setContentText("Your text")
            mBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            mBuilder.priority = NotificationCompat.PRIORITY_MAX
            mBuilder.setContentIntent(pendingIntent)

            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE)
                    as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "CH_ID"
                val channel = NotificationChannel(
                        channelId,
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_HIGH)
                mNotificationManager.createNotificationChannel(channel)
                mBuilder.setChannelId(channelId)
            }

            mNotificationManager.notify(10, mBuilder.build())
        }
    }

}