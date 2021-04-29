package com.oshovenko.cardapp.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.oshovenko.cardapp.R

@BindingAdapter("errorMessage")
fun TextInputLayout.errorMessage(errorState: Boolean) {
    error = if (errorState) {
        resources.getString(R.string.field_is_empty)
    } else ""
}

@BindingAdapter("multilineText")
fun TextView.multilineText(string: String) {
    val buffer = StringBuffer()
    string.forEachIndexed { index, element ->
        buffer.append(element)
        if (index % 30 == 0 && index != 0) {
            buffer.append("\n")
        }
    }
    text = buffer.toString()
}
