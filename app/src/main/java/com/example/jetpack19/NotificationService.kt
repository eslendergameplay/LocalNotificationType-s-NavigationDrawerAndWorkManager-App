package com.example.jetpack19

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class NotificationService(private val context:Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotif(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle("Titulo.").setContentText("Texto a Colocar.")
            .setSmallIcon(R.drawable.notif)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true).build()

        notificationManager.notify(Random.nextInt(),notification)
    }

    fun showLargeNotification(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle("Titulo Largo.")
            .setContentText("Texto a colocar").setSmallIcon(R.drawable.notif)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Texto a colcar por Eslender : En este día especial, quiero que sepas que cada latido de mi corazón lleva tu nombre y que mi amor por ti crece con cada amanecer». «Eres el sol que ilumina cada día de mi vida, y en tu cumpleaños, quiero que sientas cuánto te admiro y te amo. Cada momento a tu lado es un regalo que atesoro"))
            .setAutoCancel(true).build()

        notificationManager.notify(Random.nextInt(),notification)
    }

    fun showInboxNotification(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle("Titulo.").setContentText("Texto A colocar.")
            .setSmallIcon(R.drawable.notif)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("Linea 1.")
                .addLine("Linea 2.")
                .addLine("Linea 3.")
                .addLine("Linea 4.")
                .addLine("Linea 5.")
            )
            .setAutoCancel(true).build()
        notificationManager.notify(Random.nextInt(),notification)
    }

    private fun Context.bitmapFromResource(@DrawableRes resId:Int) =
        BitmapFactory.decodeResource(resources,resId)

    fun showImageNotification(){
        val image = context.bitmapFromResource(R.drawable.notificacion)

        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle("Titulo.")
            .setContentText("Texto a Colocar.")
            .setSmallIcon(R.drawable.notif)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setLargeIcon(image)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(image).bigLargeIcon(null as Bitmap?))
            .setAutoCancel(true).build()

        notificationManager.notify(Random.nextInt(),notification)
    }
}

