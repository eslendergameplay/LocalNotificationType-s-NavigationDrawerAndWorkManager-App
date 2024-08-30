package com.example.jetpack19.components

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.jetpack19.navigation.ItemsMenuLateral
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(navC:NavController,drawerState: DrawerState,content: @Composable () -> Unit){
    val scope = rememberCoroutineScope()

    val menuItems = listOf(ItemsMenuLateral.item_1, ItemsMenuLateral.item_2, ItemsMenuLateral.item_3)

    ModalNavigationDrawer(drawerState = drawerState,drawerContent = {
        ModalDrawerSheet {
            menuItems.forEach {item->
                NavigationDrawerItem(label = { Text(text = item.title) }, icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = ""
                )}, selected = false, onClick = {
                    scope.launch {
                    drawerState.close()
                    }
                    navC.navigate(item.ruta)
                })
            }
        }
    }) {
       content()
    }

}