package com.example.logoquizapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuizRepository @Inject constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource) {

    suspend fun getQuizzes(): List<QuizLocalDataModel> {
        //We can replace with remote data source when needed
        return withContext(Dispatchers.IO) {
             localDataSource.getQuizzes()
        }
    }

}