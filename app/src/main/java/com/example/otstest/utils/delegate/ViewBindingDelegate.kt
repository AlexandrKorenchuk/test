package com.example.otstest.utils.delegate

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

class ViewBindingDelegate<B : ViewBinding>(
    private val fragment: Fragment,
    private val viewBindingClass: Class<B>
) {

    var binding: B? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): B {
        val viewLifecycleOwner = fragment.viewLifecycleOwner
        return when {
            viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.DESTROYED -> throw IllegalStateException(
                "Called after onDestroyView()"
            )
            fragment.view != null -> getOrCreateBinding(viewLifecycleOwner)
            else -> throw IllegalStateException("Called before onDestroyView()")
        }
    }

    private fun getOrCreateBinding(viewLifecycleOwner: LifecycleOwner): B {
        return this.binding ?: let {
            val method = viewBindingClass.getMethod("bind", View::class.java)
            val binding = method.invoke(null, fragment.view) as B
            viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    super.onDestroy(owner)
                    this@ViewBindingDelegate.binding = null
                }
            })
            this.binding = binding
            binding
        }
    }
}