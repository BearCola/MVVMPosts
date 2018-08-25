package com.naver.nozzle.device

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object DisposableManager {

    private var compositeDisposable: CompositeDisposable? = null

    fun add(disposable: Disposable) {
        getCompositeDisposable()?.add(disposable)
    }

    fun dispose() {
        getCompositeDisposable()?.dispose()
    }

    private fun getCompositeDisposable(): CompositeDisposable? {

        when {
            compositeDisposable == null -> compositeDisposable = CompositeDisposable()
            compositeDisposable?.isDisposed == true -> compositeDisposable = CompositeDisposable()
        }

        return compositeDisposable
    }
}