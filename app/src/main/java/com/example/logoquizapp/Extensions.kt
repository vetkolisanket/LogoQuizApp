package com.example.logoquizapp

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    GlideApp.with(this.context).load(url).into(this)
}