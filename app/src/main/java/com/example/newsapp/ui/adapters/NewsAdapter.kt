package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.api.models.Article
import com.example.newsapp.databinding.ArticleItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticlesViewHolder>() {

    private val diffCallback = object : ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder =
        ArticlesViewHolder(
            ArticleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ArticlesViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClickListener?.let {
                    it(differ.currentList[adapterPosition])
                }
            }
        }

        fun bind(article: Article) {
            binding.apply {
                Glide.with(itemView).load(article.urlToImage).into(ivArticleImage)
                tvSource.text = article.source.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}