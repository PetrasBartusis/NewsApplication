package com.example.newsapplication.main

import android.os.Bundle
import com.example.newsapplication.R
import com.example.newsapplication.main.newslist.NewsListFragment
import com.example.newsapplication.utils.activity.openFragment
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(R.id.container, NewsListFragment.newInstance(), false)
    }

    fun showMessage(message: String) {
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show()
    }
}
