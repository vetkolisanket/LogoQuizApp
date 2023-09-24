package com.example.logoquizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val quizzes = mutableListOf<Quiz>()
    private val _quizLD: MutableLiveData<Quiz> = MutableLiveData()
    val quizLD: LiveData<Quiz> = _quizLD
    private val _onAllQuizAnsweredLD: MutableLiveData<Boolean> = MutableLiveData()
    val onAllQuizAnsweredLD: LiveData<Boolean> = _onAllQuizAnsweredLD
    private var currentQuizPosition = 0

    fun loadQuizzes() {
        viewModelScope.launch {
            quizzes.addAll(quizRepository.getQuizzes())
            _quizLD.value = quizzes[currentQuizPosition]
        }
    }

    fun onQuizAnswered() {
        currentQuizPosition++
        if (currentQuizPosition == quizzes.size) {
            _onAllQuizAnsweredLD.value = true
        } else {
            _quizLD.value = quizzes[currentQuizPosition]
        }
    }

    private val quizRepository by lazy { QuizRepository() }
}