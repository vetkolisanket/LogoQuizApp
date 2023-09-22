package com.example.logoquizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquizapp.databinding.ItemAnswerBinding
import com.example.logoquizapp.databinding.ItemGuessBinding

class GuessAdapter: RecyclerView.Adapter<GuessAdapter.GuessViewHolder>() {

    class GuessViewHolder(binding: ItemGuessBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuessViewHolder {
        val binding = ItemGuessBinding.inflate(LayoutInflater.from(parent.context))
        return GuessViewHolder(binding)
    }

    private var guessChar: String = "ABC"

    override fun getItemCount(): Int {
        return guessChar.length
    }

    fun setData(ans: String) {
        guessChar = ans
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GuessViewHolder, position: Int) {
        holder.bind()
    }

}