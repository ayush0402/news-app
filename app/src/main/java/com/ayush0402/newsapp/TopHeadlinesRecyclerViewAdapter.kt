package com.ayush0402.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TopHeadlinesRecyclerViewAdapter(var newsarray: ArrayList<NewsData>) :
    RecyclerView.Adapter<TopHeadlinesRecyclerViewAdapter.TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.top_headlines_item_view, parent, false)
        return TopHeadlinesViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        holder.title.text = newsarray[position].newsTitle
        holder.description.text = newsarray[position].newsDescription
        Glide.with(holder.image.context).load(newsarray[position].newsImageUrl).into(holder.image)
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
