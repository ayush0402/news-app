package com.ayush0402.newsapp.Adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayush0402.newsapp.NewsData
import com.ayush0402.newsapp.R
import com.bumptech.glide.Glide

class NewsListRecyclerViewAdapter(var newsarray: ArrayList<NewsData>) :
    RecyclerView.Adapter<NewsListRecyclerViewAdapter.TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(
            R.layout.news_list_item_view,
            parent,
            false
        )
        return TopHeadlinesViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        holder.title.text = newsarray[position].newsTitle
        holder.description.text = newsarray[position].newsDescription
        if (holder.description.text == "null") {
            holder.description.text = "No description available."
        }
        Glide.with(holder.image.context).load(newsarray[position].newsImageUrl).into(holder.image)

        holder.itemView.setOnClickListener {
            val website: String = newsarray[position].newsUrl
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            it.context.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int {
        return newsarray.size
    }

    class TopHeadlinesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.top_headlines_item_title)
        val description: TextView = view.findViewById(R.id.top_headlines_item_description)
        val image: ImageView = view.findViewById(R.id.top_headlines_item_image)
    }
}
