package com.example.newsapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.data.api.Resource
import com.example.newsapp.databinding.FragmentSavedNewsBinding
import com.example.newsapp.presentation.NewsActivity
import com.example.newsapp.presentation.adapters.NewsAdapter
import com.example.newsapp.presentation.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchNewsFragment : Fragment() {
    companion object {
        private const val TAG = "debugtag"
        private const val SEARCH_NEWS_TIME_DELAY = 500L
    }

    private lateinit var binding: FragmentSavedNewsBinding
    private lateinit var newsViewModel: NewsViewModel

    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = (activity as NewsActivity).newsViewModel

        setupRecyclerView()

        var job: Job? = null

        binding.etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = lifecycleScope.launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        newsViewModel.searchNews(editable.toString()).collect { response ->
                            when (response) {
                                is Resource.Success -> {
                                    hideProgressBar()
                                    response.data?.let { newsResponse ->
                                        newsAdapter.differ.submitList(newsResponse.articles)
                                    }
                                }
                                is Resource.Error -> {
                                    hideProgressBar()
                                    response.message?.let { message ->
                                        Log.e(TAG, message)
                                    }
                                }
                                is Resource.Loading -> {
                                    showProgressBar()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvSearchNews.adapter = newsAdapter
            rvSearchNews.layoutManager = LinearLayoutManager(activity)
        }
    }
}