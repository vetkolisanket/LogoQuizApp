package com.example.logoquizapp

interface QuizDataSource {

    fun getQuizzes(): List<QuizLocalDataModel>

}