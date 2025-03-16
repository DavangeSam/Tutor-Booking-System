package com.example.tutorbookingsystem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TutorViewModel : ViewModel() {
    private val apiService = RetrofitClient.apiService
    private val apolloClient = GraphQLClient.apolloClient

    fun fetchTutors(subject: String?, onResult: (List<Tutor>) -> Unit) {
        viewModelScope.launch {
            val tutors = apiService.getTutors(subject)
            onResult(tutors)
        }
    }
}
