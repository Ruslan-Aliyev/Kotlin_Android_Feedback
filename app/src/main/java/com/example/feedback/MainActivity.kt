package com.example.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setStatePageAdapter()
    }

    private fun  initViews(){
        viewPager = findViewById<ViewPager>(R.id.pager)
        tabLayout = findViewById<TabLayout>(R.id.tabs)
    }

    private fun setStatePageAdapter(){

        val tabsAdapter:TabsAdapter = TabsAdapter(supportFragmentManager)
        tabsAdapter.addFragment(WebForm(),"Online Contact Form")
        tabsAdapter.addFragment(Email(),"Email")

        viewPager.adapter = tabsAdapter
        tabLayout.setupWithViewPager(viewPager,true)

    }
}
