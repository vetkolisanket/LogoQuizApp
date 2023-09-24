package com.example.logoquizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquizapp.databinding.ItemAnswerBinding

class AnswerAdapter: RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    val cells: MutableList<Cell> = mutableListOf()
    var position = 0
    var callback: AnswerAdapter.Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context))
        return AnswerViewHolder(binding)
    }

    fun setData(ans: String) {
        position = 0
        cells.clear()
        for (c in ans) {
            cells.add(Cell(c, false))
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cells.size
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind()
    }

    fun onGuessClick(guess: Char) {
        if (guess != cells[position].char) {
            callback?.onWrongGuess()
        } else {
            callback?.onRightGuess()
            cells[position].isGuessed = true
            notifyItemChanged(position)
            position++
            if (position == cells.size) {
                callback?.onAllCharsAnswered()
            }
        }
    }

    interface Callback {
        fun onWrongGuess()
        fun onRightGuess()
        fun onAllCharsAnswered()
    }

    inner class AnswerViewHolder(val binding: ItemAnswerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val cell = cells[bindingAdapterPosition]
            binding.tvCharacter.text =
                if (cell.isGuessed)
                    cells[bindingAdapterPosition].char.toString()
                else "?"
        }

    }

}