package com.example.otstest.presentation.base

import com.example.utils.provider.BaseSchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<V : MvpView>(
    protected val schedulers: BaseSchedulerProvider
) : MvpPresenter<V>() {

    protected var isViewAttached = false
    protected var subscriptions = CompositeDisposable()

    override fun attachView(view: V) {
        isViewAttached = true
        super.attachView(view)
    }

    override fun detachView(view: V) {
        isViewAttached = false
        super.detachView(view)
    }

    override fun onDestroy() {
        subscriptions.dispose()
        super.onDestroy()
    }
}