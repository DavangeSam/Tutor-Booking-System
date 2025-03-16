package com.example.tutorbookingsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this).get(TutorViewModel::class.java)
            TutorListScreen(viewModel)
        }
    }
}
