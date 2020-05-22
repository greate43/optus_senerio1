package com.greate43.sk.optussenerioone

import android.graphics.Color.blue
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.buttons_list.*
import kotlinx.android.synthetic.main.content_scrolling.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var adapter: ItemAdapter
     var data  = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        init()

        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = sectionsPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        btnBlue.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                buttonsList.setBackgroundColor(resources.getColor(R.color.blue,null))
            } else {
                buttonsList.setBackgroundColor(resources.getColor(R.color.blue))
            }
        }

        btnGreen.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                buttonsList.setBackgroundColor(resources.getColor(R.color.green,null))
            } else {
                buttonsList.setBackgroundColor(resources.getColor(R.color.green))
            }
        }

        btnRed.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                buttonsList.setBackgroundColor(resources.getColor(R.color.red,null))
            } else {
                buttonsList.setBackgroundColor(resources.getColor(R.color.red))
            }
        }
    }

    fun init() {
        // set up the RecyclerView
        for (i in 0 until 5){
            data.add("item${i+1}")
        }
        adapter = ItemAdapter { data->
         displayItemLbl.text = data
        }

        adapter.setData(data)

        mainRecyclerView.layoutManager = LinearLayoutManager(this).apply {
            orientation = RecyclerView.HORIZONTAL
        }
        mainRecyclerView.adapter = adapter
        mainRecyclerView.adapter = adapter
    }

}
