package com.ayush0402.newsapp
//
//import android.util.Log
//import androidx.fragment.app.FragmentActivity
//import com.android.volley.toolbox.JsonObjectRequest
//import com.android.volley.toolbox.Volley
//import org.json.JSONArray
//
//class NewsAPIManager() {
//    companion object{
//        fun getNewsArray(apiUrl: String, fragmentActivity : FragmentActivity?): ArrayList<NewsData>{
//            var newsList  = ArrayList<NewsData>()
//
//            val queue = Volley.newRequestQueue(fragmentActivity)
//            val jsonObjectRequest = object: JsonObjectRequest(
//                Method.GET, apiUrl, null,
//                { response ->
//
//                    val allArticles : JSONArray = response.getJSONArray("articles")
//                    for(i in 0 until allArticles.length()){
//                        val _article = allArticles.getJSONObject(i)
//
//                        val _title = _article.getString("title")
//                        val _description = _article.getString("description")
//                        val _url = _article.getString("url")
//                        val _imageUrl = _article.getString("urlToImage")
//                        val _content = _article.getString("content")
//                        val _sourceObject = _article.getJSONObject("source")
//                        val _sourceName = _sourceObject.getString("name")
//
//                        val _news = NewsData(_title,_description,_url,_imageUrl,_content,_sourceName)
//                        newsList.add(_news)
//                    }
//                    Log.i("api- response","API fetched")
//                },
//                { error ->
//                    Log.i("api-response","couldn't fetch the API")
//                }
//            )
//            // overriding function to add Headers.
//            {
//                override fun getHeaders(): MutableMap<String, String> {
//                    val headers = HashMap<String, String>()
//                    headers["User-Agent"]="Mozilla/5.0"
//                    return headers
//                }
//            }
//            queue.add(jsonObjectRequest)
//
//            return newsList
//        }
//    }
//}