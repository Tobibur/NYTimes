package com.tobibur.nytimes.view.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.nytimes.R
import com.tobibur.nytimes.data.model.Result
import com.tobibur.nytimes.utils.inflate
import com.tobibur.nytimes.utils.load
import kotlinx.android.synthetic.main.article_layout_item.view.*

class ArticlesRecyclerAdapter(
    private val results: List<Result>,
    private val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<ArticlesRecyclerAdapter.ArticlesViewHolder>() {

    inner class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(parent.inflate(R.layout.article_layout_item, false))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val result = results[position]
        holder.itemView.apply {
            if (result.media.isNotEmpty()) {
                val media = result.media.first()
                if (media.mediaMetadata.isNotEmpty()) {
                    img_article.load(media.mediaMetadata.first().url, context)
                }
            }

            txt_title.text = result.title
            txt_author.text = result.byline
            txt_date.text = result.publishedDate
            setOnClickListener {
                it.tag = result
                onClickListener.onClick(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }
}