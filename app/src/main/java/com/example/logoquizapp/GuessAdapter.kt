package com.example.logoquizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquizapp.databinding.ItemGuessBinding

class GuessAdapter : RecyclerView.Adapter<GuessAdapter.GuessViewHolder>() {

    private val guessChars = mutableListOf<Char>()
    var callback: GuessAdapter.Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuessViewHolder {
        val binding = ItemGuessBinding.inflate(LayoutInflater.from(parent.context))
        return GuessViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return guessChars.size
    }

    fun setData(ans: List<Char>) {
        guessChars.clear()
        guessChars.addAll(ans)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GuessViewHolder, position: Int) {
        holder.bind()
    }

    interface Callback {
        fun onGuessClick(c: Char)
    }

    inner class GuessViewHolder(private val binding: ItemGuessBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvCharacter.setOnClickListener {
                if (bindingAdapterPosition != RecyclerView.NO_POSITION
                    && guessChars.size > bindingAdapterPosition
                ) {
                    callback?.onGuessClick(guessChars[bindingAdapterPosition])
                }
            }
        }

        fun bind() {
            binding.tvCharacter.text = guessChars[bindingAdapterPosition].toString()
        }
    }

}