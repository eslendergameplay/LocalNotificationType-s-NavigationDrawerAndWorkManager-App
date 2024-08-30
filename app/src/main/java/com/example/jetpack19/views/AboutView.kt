package com.example.jetpack19.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutView(navC:NavController){
    Scaffold (topBar = { CenterAlignedTopAppBar(title = { Text(text = "About View.")}, navigationIcon = {
        IconButton(onClick = {navC.popBackStack()}) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        }
    })}){pad->
        Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(pad)){
            Text(text = "About View.")
        }

    }
}