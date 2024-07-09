package com.leventsurer.lifecycleawareclasscase

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class CounterComponentClass : DefaultLifecycleObserver {

    var counter = MutableLiveData<Int>().apply { value = 0 }
    var counterJob : Job? = null
    var appDeactivetedCounter = MutableLiveData<Int>().apply { value = 0 }
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        increaseCounter()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onPause(owner)
        stopCounter()
    }

    private fun increaseCounter(){
        counterJob = CoroutineScope(Dispatchers.IO).launch{
            while (isActive){
                delay(1000L)
                counter.postValue(counter.value?.plus(1))
            }
        }
    }

    private fun stopCounter(){
        appDeactivetedCounter.postValue(appDeactivetedCounter.value?.plus(1))
        counterJob?.cancel()
    }

}