package com.example.logoquizapp

class LocalDataSource: QuizDataSource {
    override fun getQuizzes(): List<QuizLocalDataModel> {
        return listOf(
            QuizLocalDataModel(
            "https://www.dsource.in/sites/default/files/resource/logo-design/logos/logos-representing-india/images/01.jpeg",
            "AADHAAR"),
            QuizLocalDataModel(
                "https://static.digit.in/default/thumb_101067_default_td_480x480.jpeg",
                "PHONEPE"),
            QuizLocalDataModel(
                "https://cdn.iconscout.com/icon/free/png-256/bhim-3-69845.png",
                "BHIM"),
            QuizLocalDataModel(
                "https://media.glassdoor.com/sqll/300494/flipkart-com-squarelogo-1433217726546.png",
                "FLIPKART"),
            QuizLocalDataModel(
                "https://logok.org/wp-content/uploads/2014/05/Walmart-Logo-880x645.png",
                "WALMART"),
            QuizLocalDataModel(
                "https://www.thestylesymphony.com/wp-content/uploads/2015/05/Myntra-logo.png",
                "MYNTRA"),
        )
    }


}