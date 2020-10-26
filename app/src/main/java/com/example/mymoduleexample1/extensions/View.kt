package com.example.mymoduleexample1.extensions

import android.view.View

fun View.visible(visible: Boolean = false){
    visibility = if (visible) View.VISIBLE else View.GONE
}