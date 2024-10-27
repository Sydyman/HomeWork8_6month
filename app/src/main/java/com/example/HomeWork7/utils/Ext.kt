package com.example.HomeWork7.utils

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(massage: String) {
    Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
}