package com.ayush0402.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopHeadlinesRecyclerViewAdapter(var newsarray: ArrayList<NewsData>) :
    RecyclerView.Adapter<TopHeadlinesRecyclerViewAdapter.TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.top_headlines_item_view, parent, false)
        return TopHeadlinesViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        holder.v.text = newsarray[position].newsTitle
    }

    override fun getItemCount(): Int {
        return newsarray.size
    }

    class TopHeadlinesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val v : TextView = view.findViewById(R.id.top_headlines_item_title)
    }
}