package com.ayush0402.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayush0402.newsapp.databinding.FragmentTopHeadlinesBinding

class TopHeadlinesFragment : Fragment() {

    private var _binding : FragmentTopHeadlinesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopHeadlinesBinding.inflate(inflater,container,false)

        var items : ArrayList<NewsData>? = null
        val nd = NewsData("HelloNews")
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)
        items!!.add(nd)


        binding.topHeadlinesRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.topHeadlinesRecyclerView.adapter = TopHeadlinesRecyclerViewAdapter(items)

        return binding.root
    }
}