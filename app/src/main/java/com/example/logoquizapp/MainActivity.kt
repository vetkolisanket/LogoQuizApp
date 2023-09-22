package com.example.logoquizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logoquizapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    val quiz = Quiz(
        "https://www.dsource.in/sites/default/files/resource/logo-design/logos/logos-representing-india/images/01.jpeg",
        "AADHAAR")

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()
    private val answerAdapter: AnswerAdapter by lazy { AnswerAdapter() }
    private val guessAdapter: GuessAdapter by lazy { GuessAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.loadQuizzes()
        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.rvAnswer.apply {
            this.adapter = answerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
        binding.rvGuess.apply {
            adapter = guessAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initObservers() {
        viewModel.quizLiveData.observe(this) {
            it?.let { quiz ->
                binding.ivLogo.load(quiz.imageUrl)
                answerAdapter.setData(quiz.name)
                guessAdapter.setData(quiz.name)
            }
        }
    }
}

