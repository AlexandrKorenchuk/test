package com.example.utils.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter

interface BroadcastManager {
    fun registerGlobalReceiver(receiver: BroadcastReceiver, filter: IntentFilter)
    fun unregisterGlobalReceiver(receiver: BroadcastReceiver)
}

internal class BroadcastManagerImpl(private val context: Context) : BroadcastManager {
    override fun registerGlobalReceiver(receiver: BroadcastReceiver, filter: IntentFilter) {
        context.applicationContext.registerReceiver(receiver, filter)
    }

    override fun unregisterGlobalReceiver(receiver: BroadcastReceiver) {
        context.applicationContext.unregisterReceiver(receiver)
    }
}