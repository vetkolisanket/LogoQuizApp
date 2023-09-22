package com.example.logoquizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val quizzes = mutableListOf<Quiz>()
    private val _quizLiveData: MutableLiveData<Quiz> = MutableLiveData()
    val quizLiveData: LiveData<Quiz> = _quizLiveData


    fun loadQuizzes() {
        viewModelScope.launch {
            val quizList = quizRepository.getQuizzes()
            _quizLiveData.value = quizList[0];
        }
    }

    private val quizRepository by lazy { QuizRepository() }
}