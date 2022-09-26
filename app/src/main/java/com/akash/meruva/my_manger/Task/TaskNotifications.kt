package com.akash.meruva.my_manger.Task

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.akash.meruva.my_manger.MainActivity
import com.akash.meruva.my_manger.R


class TaskNotifications : BroadcastReceiver() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent)
    {
        var i = Intent(context , MainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        var pi = PendingIntent.getActivity(context , 0 , i , PendingIntent.FLAG_IMMUTABLE)


        val notification = NotificationCompat.Builder(context , "Task Notifications")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(intent.getStringExtra("titleExtra"))
            .setContentText(intent.getStringExtra("messageExtra"))
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pi)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(123, notification.build())
    }

}