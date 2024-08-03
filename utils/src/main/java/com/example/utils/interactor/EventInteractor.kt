package com.example.utils.interactor

import com.example.utils.provider.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

interface EventInteractor {
    fun subscribeToEvents(): Observable<Boolean>
    fun sendEvent()
    fun complete()
}

internal class EventInteractorImpl(
    private val schedulers: BaseSchedulerProvider
) : EventInteractor {
    private var messagesSubject: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    override fun subscribeToEvents(): Observable<Boolean> =
        messagesSubject.observeOn(schedulers.ui())

    override fun sendEvent() {
        messagesSubject.onNext(true)
    }

    override fun complete() {
        messagesSubject.onComplete()
    }
}