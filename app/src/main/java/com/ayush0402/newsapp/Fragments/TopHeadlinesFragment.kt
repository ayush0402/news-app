package com.ayush0402.newsapp.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.ayush0402.newsapp.Adapters.NewsListRecyclerViewAdapter
import com.ayush0402.newsapp.NewsData
import com.ayush0402.newsapp.Secret
import com.ayush0402.newsapp.ViewModels.TopHeadlinesFragmentViewModel
import com.ayush0402.newsapp.databinding.FragmentTopHeadlinesBinding
import org.json.JSONArray

class TopHeadlinesFragment : Fragment() {

    private var _binding : FragmentTopHeadlinesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : TopHeadlinesFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopHeadlinesBinding.inflate(inflater,container,false)

        Log.i("viewModel Fragment","viewModelProvidersof called")
        viewModel = ViewModelProviders.of(this).get(TopHeadlinesFragmentViewModel::class.java)

        val queue = Volley.newRequestQueue(activity)
        val newsList = ArrayList<NewsData>()

        val apiUrl =
            "https://newsapi.org/v2/top-headlines?country=in&apiKey=${Secret.API_KEY}"

            Log.i("TopHeadlinesViewModel", "Created")
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
                    binding.topHeadlinesRecyclerView.layoutManager = LinearLayoutManager(activity)
                    binding.topHeadlinesRecyclerView.adapter = NewsListRecyclerViewAdapter(newsList)
                    binding.topHeadlinesProgressBar.isVisible = false
                    Log.i("api- response", "API fetched")
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
