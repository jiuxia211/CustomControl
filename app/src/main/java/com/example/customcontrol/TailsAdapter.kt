package com.example.customcontrol

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customcontrol.databinding.TailsItemBinding
import com.example.recycleview.Tails

class TailsAdapter(val tailsList: MutableList<Tails>) :
    RecyclerView.Adapter<TailsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: TailsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tailsName: TextView = binding.tailsName
        val tailsImage: ImageView = binding.tailsImage

        fun addSwipeToDelete(onDelete: () -> Unit) {
            binding.swipeToDeleteView.setOnSwipeDeleteListener(onDelete)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tails = tailsList[position]
        holder.tailsName.text = tails.name
        holder.tailsImage.setImageResource(tails.ImageId)
        holder.addSwipeToDelete {
            tailsList.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return tailsList.size
    }
}