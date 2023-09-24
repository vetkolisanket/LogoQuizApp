package com.example.logoquizapp

import android.widget.ImageView

fun ImageView.load(url: String) {
    GlideApp.with(this.context).load(url).into(this)
}