package com.ayush0402.newsapp

import android.content.Intent
import android.net.Uri
import android.telecom.Call.Details
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar


class TopHeadlinesRecyclerViewAdapter(var newsarray: ArrayList<NewsData>) :
    RecyclerView.Adapter<TopHeadlinesRecyclerViewAdapter.TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(
            R.layout.top_headlines_item_view,
            parent,
            false
        )
        return TopHeadlinesViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        holder.title.text = newsarray[position].newsTitle
        holder.description.text = newsarray[position].newsDescription
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
        val title : TextView = view.findViewById(R.id.top_headlines_item_title)
        val description : TextView = view.findViewById(R.id.top_headlines_item_description)
        val image : ImageView = view.findViewById(R.id.top_headlines_item_image)
    }
}
