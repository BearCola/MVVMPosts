package net.gahfy.mvvmposts.ui.post

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import net.gahfy.mvvmposts.base.BaseViewModel
import java.util.concurrent.TimeUnit

class PomodoroViewModel:BaseViewModel() {

    val changeText: MutableLiveData<String> = MutableLiveData()

    init{
        startTimer()
    }

    @SuppressLint("CheckResult")
    private fun startTimer() {
        val disposable = Observable
                .interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
        
        disposable.subscribe {
            changeText.value = it.toString()
        }
    }
}