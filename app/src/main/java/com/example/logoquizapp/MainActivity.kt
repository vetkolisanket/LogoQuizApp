package com.example.logoquizapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
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
            answerAdapter.callback = object : AnswerAdapter.Callback {
                override fun onWrongGuess() {
                    Toast.makeText(this@MainActivity, "Wrong guess", Toast.LENGTH_SHORT).show()
                }

                override fun onRightGuess() {
//                    Toast.makeText(this@MainActivity, "Right guess", Toast.LENGTH_SHORT).show()
                }

                override fun onAllCharsAnswered() {
                    Toast.makeText(this@MainActivity, "Next quiz", Toast.LENGTH_SHORT).show()
                    viewModel.onQuizAnswered()
                }

            }
        }
        binding.rvGuess.apply {
            adapter = guessAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 10)
            guessAdapter.callback = object : GuessAdapter.Callback {
                override fun onGuessClick(c: Char) {
                    answerAdapter.onGuessClick(c)
                }

            }
        }
    }

    private fun initObservers() {
        viewModel.apply {
            quizLD.observe(this@MainActivity) {
                it?.let { quiz ->
                    binding.ivLogo.load(quiz.imageUrl)
                    answerAdapter.setData(quiz.name)
                    guessAdapter.setData(jumbleUp(quiz.name))
                }
            }
            onAllQuizAnsweredLD.observe(this@MainActivity) {
                if (it) {
                    Toast.makeText(
                        this@MainActivity,
                        "Congratulations! You have answered all the quizzes",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun jumbleUp(name: String): List<Char> {
        val charList = name.toCharArray().toMutableList()
        val len = name.length
        val randChars = getRandomChars(20-len)
        return randomisedChars(charList, randChars)
    }

    private fun randomisedChars(charList: MutableList<Char>, randChars: List<Char>): List<Char> {
        charList.addAll(randChars);
        charList.shuffle()
        return charList
    }

    private fun getRandomChars(len: Int): List<Char> {
        val list = mutableListOf<Char>()
        for (i in 0 until len) {
            list.add(('A'..'Z').random())
        }
        return list
    }
}

