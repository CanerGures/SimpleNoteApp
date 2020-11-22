package com.example.simplenoteapp.util

import android.content.Intent
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity

infix fun <T : AppCompatActivity> AppCompatActivity.extStartActivity(className: Class<T>) {
    startActivity(Intent(this, className))
}

fun validateNoteCreate(
    title: String,
    note: String,
): Boolean {

    return !(TextUtils.isEmpty(title)) && !(TextUtils.isEmpty(note))

}

fun validateImageUrl(
    url: String?

): String {

    return if (url != "") {
        val checkHTTPS = url!!.take(8)
        if (checkHTTPS == "https://") {
            url
        } else {
            "https://${url}"
        }
    } else {
        url
    }
}