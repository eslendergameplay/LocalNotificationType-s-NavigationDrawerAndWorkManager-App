package com.example.jetpack19.views

import android.app.Notification
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.jetpack19.NotificationService
import com.example.jetpack19.NotificationWorker
import com.example.jetpack19.components.MenuLateral
import com.example.jetpack19.components.TopBar

@Composable
fun HomeView(navC:NavController){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MenuLateral(navC = navC, drawerState = drawerState) {
        ContentHomeView(drawerState)
    }
}

@Composable
fun ContentHomeView(drawerState:DrawerState){
    Scaffold (topBar = { TopBar(drawerState = drawerState, title = "Principal O Home.")}){pad->
        NotificationsView(pad)
    }
}

@Composable
fun NotificationsView(paddingVs:PaddingValues){
    val context = LocalContext.current
    val notificationService = NotificationService(context)
    Column (modifier = Modifier
        .padding(paddingVs)
        .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Notifications.")
        Button(onClick = {notificationService.showBasicNotif()}) {
            Text(text = "Basic Notification.")
        }
        Button(onClick = {notificationService.showLargeNotification()}) {
            Text(text = "Large Notification.")
        }
        Button(onClick = {notificationService.showInboxNotification()}) {
            Text(text = "Inbox Notification.")
        }
        Button(onClick = {notificationService.showImageNotification()}) {
            Text(text = "Image Notification.")
        }
        Button(onClick = {NotificationWorker.releaseNotification(context)}) {
            Text(text = "Notificacion de Fondo.")
        }
    }
}