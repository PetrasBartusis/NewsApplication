package com.example.newsapplication.main

import android.os.Bundle
import com.example.newsapplication.R
import com.example.newsapplication.main.newslist.NewsListFragment
import com.example.newsapplication.utils.activity.openFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(R.id.container, NewsListFragment.newInstance(), false)
    }
}
