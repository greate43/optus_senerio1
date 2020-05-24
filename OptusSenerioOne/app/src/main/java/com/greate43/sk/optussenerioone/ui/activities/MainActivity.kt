package com.greate43.sk.optussenerioone.ui.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.greate43.sk.optussenerioone.R
import com.greate43.sk.optussenerioone.adapter.ItemAdapter
import com.greate43.sk.optussenerioone.adapter.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.buttons_list.*
import kotlinx.android.synthetic.main.content_scrolling.*

const val COLOR_EXTRA = "COLOR_EXTRA"
const val DISPLAY_ITEM_EXTRA = "DISPLAY_ITEM_EXTRA"
const val VALUE_NOT_SET = -1

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ItemAdapter
    var color: Int = VALUE_NOT_SET
    var data = mutableListOf<String>()
    var displayItemData: String = ""
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
            setButtonBackgroundColor(R.color.blue)
        }

        btnGreen.setOnClickListener {
            setButtonBackgroundColor(R.color.green)
        }

        btnRed.setOnClickListener {
            setButtonBackgroundColor(R.color.red)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COLOR_EXTRA, color)
        outState.putString(DISPLAY_ITEM_EXTRA, displayItemData)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        color = savedInstanceState.getInt(COLOR_EXTRA, VALUE_NOT_SET)
        Log.d("d", "color $color")
        displayItemData = savedInstanceState.getString(
            DISPLAY_ITEM_EXTRA,
            resources.getString(R.string.displayItemStringDefault)
        )
        if (color != VALUE_NOT_SET) {
            setButtonBackgroundColor(color)
        }
        displayItem()

    }


    private fun setButtonBackgroundColor(colorValue: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            color = colorValue
            buttonsList.setBackgroundColor(resources.getColor(color, null))
        } else {
            color = colorValue
            buttonsList.setBackgroundColor(resources.getColor(color))
        }

    }

    private fun init() {
        // set up the RecyclerView
        for (i in 0 until 5) {
            data.add("item${i + 1}")
        }
        adapter = ItemAdapter { data ->
            displayItemData = data
            displayItem()
        }

        adapter.setData(data)

        mainRecyclerView.layoutManager = LinearLayoutManager(this).apply {
            orientation = RecyclerView.HORIZONTAL
        }
        mainRecyclerView.adapter = adapter
    }

    private fun displayItem() {
        displayItemLbl.text = displayItemData
    }

}
