package com.example.newsapp.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ArticleItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ArticlesViewHolder(val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}