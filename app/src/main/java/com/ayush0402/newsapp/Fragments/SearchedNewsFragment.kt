package com.ayush0402.newsapp.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.ayush0402.newsapp.Adapters.NewsListRecyclerViewAdapter
import com.ayush0402.newsapp.NewsData
import com.ayush0402.newsapp.Fragments.SearchedNewsFragmentArgs
import com.ayush0402.newsapp.Secret
import com.ayush0402.newsapp.databinding.FragmentSearchedNewsBinding
import org.json.JSONArray

class SearchedNewsFragment : Fragment() {

    val args: SearchedNewsFragmentArgs by navArgs()

    private var _binding: FragmentSearchedNewsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchedNewsBinding.inflate(inflater, container, false)
        var newsList = ArrayList<NewsData>()

        val _query: String? = args.query
        val _region: Boolean = args.region
        val _category: String = args.category
        val country: String = if (_region) "us" else "in"

        val queue = Volley.newRequestQueue(activity)
        val apiUrl =
            if(_category=="unselected")"https://newsapi.org/v2/top-headlines?q=${_query}&country=${country}&apiKey=${Secret.API_KEY}"
            else "https://newsapi.org/v2/top-headlines?q=${_query}&country=${country}&category=${_category}&apiKey={${Secret.API_KEY}}"
        Log.i("xyz",apiUrl)
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.GET, apiUrl, null,
            { response ->

                val allArticles: JSONArray = response.getJSONArray("articles")
                for (i in 0 until allArticles.length()) {
                    val _article = allArticles.getJSONObject(i)

                    val _title = _article.getString("title")
                    val _description = _article.getString("description")
                    val _url = _article.getString("url")
                    val _imageUrl = _article.getString("urlToImage")
                    val _content = _article.getString("content")
                    val _sourceObject = _article.getJSONObject("source")
                    val _sourceName = _sourceObject.getString("name")

                    val _news =
                        NewsData(_title, _description, _url, _imageUrl, _content, _sourceName)
                    newsList.add(_news)
                }
                Log.i("api- response", "API fetched")
                binding.searchedNewsRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.searchedNewsRecyclerView.adapter = NewsListRecyclerViewAdapter(newsList)
                binding.searchedNewsProgressBar.isVisible = false
            },
            { error ->
                Log.i("api-response", "couldn't fetch the API")
            }
        )
        // overriding function to add Headers.
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }

        queue.add(jsonObjectRequest)

        return binding.root
    }
}
