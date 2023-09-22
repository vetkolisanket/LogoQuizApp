package com.example.logoquizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquizapp.databinding.ItemAnswerBinding

class AnswerAdapter: RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    inner class AnswerViewHolder(val binding: ItemAnswerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val cell = cells[bindingAdapterPosition]
            binding.tvCharacter.text =
                if (cell.isGuessed)
                    cells[bindingAdapterPosition].char.toString()
                else "?"
        }

    }

    private var answer: String = "AADHAR"
    val cells: MutableList<Cell> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context))
        return AnswerViewHolder(binding)
    }

    fun setData(ans: String) {
        answer = ans
        for (c in ans) {
            cells.add(Cell(c, false))
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
//        return answer.length
        return cells.size
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind()
    }

}