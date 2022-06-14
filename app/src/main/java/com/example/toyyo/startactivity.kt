package com.example.toyyo

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_startactivity.*


class startactivity : AppCompatActivity(),clickviewholder {

    private lateinit var mAdapter: adoptorlist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity)

        recyclarview.layoutManager = LinearLayoutManager(this)
        fatchdata()
        mAdapter  = adoptorlist(this)
        recyclarview.adapter = mAdapter

    }

    fun fatchdata(){

        val url = "GET https://newsapi.org/v2/top-headlines?country=in&apiKey=375a0f0186b84fc6a590f437e16ee46a"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            {
                val newsjesonarry = it.getJSONArray("articles")
                val newsarry = ArrayList<News>()
                for (i in 0 until newsjesonarry.length()) {
                    val jesonobject = newsjesonarry.getJSONObject(i)
                    val news = News(
                        jesonobject.getString("title"),
                        jesonobject.getString("author"),
                        jesonobject.getString("url"),
                        jesonobject.getString("urlToImage")
                    )
                    newsarry.add(news)
                }
                mAdapter.updatadnews(newsarry)
            },
            {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onclickviewholder(item: News) {
       // val url = "https://google.com/"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}
