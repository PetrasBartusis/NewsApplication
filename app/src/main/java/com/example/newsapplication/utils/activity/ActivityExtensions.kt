package com.example.newsapplication.utils.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

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