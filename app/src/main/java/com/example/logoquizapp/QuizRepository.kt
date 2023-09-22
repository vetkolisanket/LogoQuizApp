package com.example.logoquizapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuizRepository {

    private val localDataSource: LocalDataSource by lazy { LocalDataSource() }
    private val remoteDataSource: RemoteDataSource by lazy { RemoteDataSource() }

    suspend fun getQuizzes(): List<Quiz> {
        //We can replace with remote data source when needed
        return withContext(Dispatchers.IO) {
             localDataSource.getQuizzes()
        }
    }

}