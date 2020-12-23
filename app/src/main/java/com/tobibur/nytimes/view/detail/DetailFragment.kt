package com.tobibur.nytimes.view.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.tobibur.nytimes.R
import com.tobibur.nytimes.utils.load
import kotlinx.android.synthetic.main.article_layout_item.view.*
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val result = args.result

        if (result.media.isNotEmpty()) {
            val media = result.media.first()
            if (media.mediaMetadata.isNotEmpty()) {
                img_detail.load(media.mediaMetadata[2].url, requireContext())
            }
        }

        txt_detail_title.text = result.title
        txt_detail_author.text = result.byline
        txt_detail_date.text = result.publishedDate
        txt_detail.text = result.abstract
    }

}