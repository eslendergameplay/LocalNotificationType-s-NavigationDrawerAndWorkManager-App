package com.example.jetpack19

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class NotificationWorker (context:Context,params:WorkerParameters):Worker(context,params) {
    override fun doWork(): Result {
        showBackNotification()
        return Result.success()
    }

    private fun showBackNotification(){
        val notification = NotificationCompat.Builder(applicationContext,"123")
            .setContentTitle("Titulo")
            .setContentText("Texto a Colocar.")
            .setSmallIcon(R.drawable.notif)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true).build()

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        notificationManager.notify(Random.nextInt(),notification)
    }

    companion object{
        fun releaseNotification(context:Context){
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresCharging(false)
                .setRequiresBatteryNotLow(false).build()

            val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
                .setConstraints(constraints)
                .setInitialDelay(7,TimeUnit.SECONDS).build()
            WorkManager.getInstance(context).enqueue(notificationWork)
        }
    }


}