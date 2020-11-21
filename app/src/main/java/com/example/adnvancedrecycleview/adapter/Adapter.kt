package com.example.adnvancedrecycleview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.adnvancedrecycleview.databinding.ItemHomeBinding
import com.example.adnvancedrecycleview.model.ResultsItem


class HomeAdapter(private val result: List<ResultsItem>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

    }

    inner class HomeViewHolder(        private val binding: ItemHomeBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultsItem){
            binding.run {
                tvName.text=result.name
            }

            }
        }


    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
