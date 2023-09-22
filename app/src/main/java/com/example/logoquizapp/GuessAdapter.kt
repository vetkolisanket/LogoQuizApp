package com.example.logoquizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquizapp.databinding.ItemGuessBinding

class GuessAdapter: RecyclerView.Adapter<GuessAdapter.GuessViewHolder>() {

    inner class GuessViewHolder(val binding: ItemGuessBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvCharacter.text = guessChars[bindingAdapterPosition].toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuessViewHolder {
        val binding = ItemGuessBinding.inflate(LayoutInflater.from(parent.context))
        return GuessViewHolder(binding)
    }

    private val guessChars = mutableListOf<Char>()

    override fun getItemCount(): Int {
        return guessChars.size
    }

    fun setData(ans: List<Char>) {
        guessChars.addAll(ans)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GuessViewHolder, position: Int) {
        holder.bind()
    }

}