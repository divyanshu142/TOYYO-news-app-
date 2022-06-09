package com.example.toyyo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_startactivity.*

class startactivity : AppCompatActivity(), adoptorlist.clickviewholder {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity)

        recyclarview.layoutManager = LinearLayoutManager(this)
        var lists = fatchdata()
        var adaptor = adoptorlist(lists, this)
        recyclarview.adapter = adaptor

    }
    fun fatchdata(): ArrayList<String>{

        val list = ArrayList<String>()
        for (i in 1..500){
            list.add("item $i")
        }
        return list
    }

    override fun onclickviewholder(item: String) {
        Toast.makeText(this, "sun beta click mat kar dijo ab $item pe", Toast.LENGTH_LONG).show()
    }
}
