package com.example.utils.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.utils.interactor.EventInteractor

class BootReceiver(private val interactor: EventInteractor) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
                interactor.sendEvent()
            }
        }
    }
}