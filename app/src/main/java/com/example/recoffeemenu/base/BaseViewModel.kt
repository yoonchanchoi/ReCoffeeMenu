package com.example.recoffeemenu.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val disposable = CompositeDisposable()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}