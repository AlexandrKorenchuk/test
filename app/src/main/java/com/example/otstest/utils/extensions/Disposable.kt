package com.example.otstest.utils.extensions

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.addTo(disposable: CompositeDisposable): Disposable {
    disposable.add(this)
    return this
}
