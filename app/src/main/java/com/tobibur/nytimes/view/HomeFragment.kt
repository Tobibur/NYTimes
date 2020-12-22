package com.tobibur.nytimes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.nytimes.R
import com.tobibur.nytimes.data.network.Outcome
import com.tobibur.nytimes.utils.toast
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecycler()
        getArticles()
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        recycler_articles.apply {
            layoutManager = linearLayoutManager
        }
    }

    private fun getArticles() {
        viewModel.getArticles(period = 7).observe(viewLifecycleOwner, Observer { outcome ->
            when (outcome) {
                is Outcome.Success -> {
                    progress_loader.visibility = View.GONE
                    val articles = outcome.data.results
                    recycler_articles.adapter = ArticlesRecyclerAdapter(articles)
                }
                is Outcome.Failure -> {
                    progress_loader.visibility = View.GONE
                    requireActivity().toast(getString(R.string.error_loading))
                    outcome.e.printStackTrace()
                }
                is Outcome.Progress -> {
                    progress_loader.visibility = View.VISIBLE
                }
            }
        })
    }

}