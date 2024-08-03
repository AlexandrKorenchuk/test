package com.example.data.receiver

import android.content.Intent
import android.content.IntentFilter
import com.example.domain.repository.BootReceiverRepository
import com.example.utils.broadcast.BootReceiver
import com.example.utils.broadcast.BroadcastManager
import com.example.utils.interactor.EventInteractor

class BootReceiverRepositoryImpl(
    private val broadcastManager: BroadcastManager, private val interactor: EventInteractor
) : BootReceiverRepository {

    private val receiver: BootReceiver by lazy {
        BootReceiver(interactor)
    }

    override fun start() {
        broadcastManager.registerGlobalReceiver(
            receiver, IntentFilter(Intent.ACTION_BOOT_COMPLETED)
        )
    }

    override fun finish() {
        broadcastManager.unregisterGlobalReceiver(receiver)
    }
}