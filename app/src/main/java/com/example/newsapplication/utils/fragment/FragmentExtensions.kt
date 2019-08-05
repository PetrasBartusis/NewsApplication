package com.example.newsapplication.utils.fragment

import android.os.Bundle

fun <T : ViewModelFragment> T.withArgs(bundleAction: Bundle.() -> Unit): T {
    arguments = Bundle().apply(bundleAction)
    return this
}