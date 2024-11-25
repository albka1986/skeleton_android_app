package com.ponomarenko.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ponomarenko.skeleton.infrastructure.ui.NavigationStack
import com.ponomarenko.skeleton.infrastructure.ui.theme.SkeletonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkeletonTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavigationStack()
                }
            }
        }
    }
}