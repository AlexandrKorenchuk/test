package com.example.otstest.utils.extensions

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.otstest.utils.delegate.ViewBindingDelegate

inline fun <reified B : ViewBinding> Fragment.viewBinding(): ViewBindingDelegate<B> {
    return ViewBindingDelegate(this, B::class.java)
}