package com.example.adnvancedrecycleview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adnvancedrecycleview.databinding.ItemHomeBinding
import com.example.adnvancedrecycleview.model.ResultsItem


class HomeAdapter(private val result: List<ResultsItem>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

    }

    inner class HomeViewHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultsItem) {
            binding.run {
                tvName.text = result.name.first
                tvCity.text = result.location.city
                tvPhone.text = result.phone
                Glide.with(binding.root).load(result.picture).circleCrop().into(ivImage)
            }

        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(result[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return result.count()
    }


}



