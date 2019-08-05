package com.example.newsapplication.utils.images

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import javax.inject.Inject

class ImageLoader @Inject constructor() {
    fun loadImage(
        imageView: ImageView,
        url: String
    ) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_image)
            .into(imageView)
    }
}