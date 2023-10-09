package com.example.logoquizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val quizLocalDataModels = mutableListOf<QuizLocalDataModel>()
    private val _quizLocalDataModelLD: MutableLiveData<QuizLocalDataModel> = MutableLiveData()
    val quizLocalDataModelLD: LiveData<QuizLocalDataModel> = _quizLocalDataModelLD
    private val _onAllQuizAnsweredLD: MutableLiveData<Boolean> = MutableLiveData()
    val onAllQuizAnsweredLD: LiveData<Boolean> = _onAllQuizAnsweredLD
    private var currentQuizPosition = 0

    fun loadQuizzes() {
        viewModelScope.launch {
            quizLocalDataModels.addAll(quizRepository.getQuizzes())
            _quizLocalDataModelLD.value = quizLocalDataModels[currentQuizPosition]
        }
    }

    fun onQuizAnswered() {
        currentQuizPosition++
        if (currentQuizPosition == quizLocalDataModels.size) {
            _onAllQuizAnsweredLD.value = true
        } else {
            _quizLocalDataModelLD.value = quizLocalDataModels[currentQuizPosition]
        }
    }

    private val quizRepository by lazy { QuizRepository() }
}