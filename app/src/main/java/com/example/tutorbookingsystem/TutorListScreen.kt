package com.example.tutorbookingsystem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TutorListScreen(viewModel: TutorViewModel = viewModel()) {
    var tutors by remember { mutableStateOf(emptyList<Tutor>()) }

    LaunchedEffect(key1 = true) {
        viewModel.fetchTutors(subject = null) { fetchedTutors ->
            tutors = fetchedTutors
        }
    }

    LazyColumn {
        items(tutors) { tutor ->
            TutorItem(tutor)
        }
    }
}

@Composable
fun TutorItem(tutor: Tutor) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = tutor.name, fontWeight = FontWeight.Bold)
            Text(text = "Subject: ${tutor.subject}")
            Text(text = "Available: ${tutor.availability}")
        }
    }
}
