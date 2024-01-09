package com.example.logoquizapp

import javax.inject.Inject

class RemoteDataSource @Inject constructor(): QuizDataSource {
    override fun getQuizzes(): List<QuizLocalDataModel> {
        TODO("make api call")
    }
}