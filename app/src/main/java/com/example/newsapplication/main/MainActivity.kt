package com.example.newsapplication.main

import android.os.Bundle
import com.example.newsapplication.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppThesefhabwefkme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun tests() : Int {
        return 3 + 5
    }
}
