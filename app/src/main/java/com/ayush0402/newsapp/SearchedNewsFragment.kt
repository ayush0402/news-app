package com.ayush0402.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayush0402.newsapp.databinding.FragmentSearchedNewsBinding
import com.ayush0402.newsapp.databinding.FragmentTopHeadlinesBinding

class SearchedNewsFragment : Fragment() {
    private var _binding : FragmentSearchedNewsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchedNewsBinding.inflate(inflater,container,false)



        return binding.root
    }
}
