package com.example.logoquizapp

class LocalDataSource: QuizDataSource {
    override fun getQuizzes(): List<Quiz> {
        return listOf(Quiz(
            "https://www.dsource.in/sites/default/files/resource/logo-design/logos/logos-representing-india/images/01.jpeg",
            "AADHAAR"))
    }


}