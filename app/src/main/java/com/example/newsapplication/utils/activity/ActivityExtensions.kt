package com.example.newsapplication.utils.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.newsapplication.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

fun FragmentActivity.openFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment, fragment::class.java.simpleName)
    if (addToBackStack) {
        transaction.addToBackStack(fragment.javaClass.name)
    } else {
        supportFragmentManager.fragments.clear()
    }
    transaction.commit()
}

fun FragmentActivity.showMessage(message: String) {
    (this as MainActivity).showMessage(message)
}