package com.example.otstest.presentation.main

import com.example.domain.event.SaveEventUseCase
import com.example.domain.receiver.FinishBootReceiverUseCase
import com.example.domain.receiver.StartBootReceiverUseCase
import com.example.otstest.presentation.base.BasePresenter
import com.example.otstest.utils.extensions.addTo
import com.example.utils.interactor.EventInteractor
import com.example.utils.provider.BaseSchedulerProvider
import moxy.MvpPresenter

class MainPresenter(
    private val startBroadcastReceiverUseCase: StartBootReceiverUseCase,
    private val finishBootReceiverUseCase: FinishBootReceiverUseCase,
    private val saveEventUseCase: SaveEventUseCase,
    private val interactor: EventInteractor,
    schedulers: BaseSchedulerProvider
) : BasePresenter<MainView>(schedulers) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        startListening()
    }

    private fun startListening() {
        startBroadcastReceiverUseCase()
        interactor.subscribeToEvents().subscribe {
            if (it) saveEvent()
        }.addTo(subscriptions)
    }

    private fun saveEvent() {
        saveEventUseCase(System.currentTimeMillis()).subscribe({}, {}).addTo(subscriptions)
    }

    override fun onDestroy() {
        finishBootReceiverUseCase()
        super.onDestroy()
    }
}