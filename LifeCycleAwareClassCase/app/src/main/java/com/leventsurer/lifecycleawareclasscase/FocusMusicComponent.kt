package com.leventsurer.lifecycleawareclasscase

import android.app.NotificationManager
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

class FocusMusicComponent(private val context: Context) : LifecycleEventObserver {


    lateinit var mediaPlayer: MediaPlayer
     var isUserPremium  = false
    init {
        initializeMediaPlayer()

    }
    fun changeUserPremiumStatus(userNewPremiumStatus:Boolean){
        isUserPremium = userNewPremiumStatus
    }
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_RESUME->{
                mediaPlayer.start()
            }
            Lifecycle.Event.ON_PAUSE->{
                if (!isUserPremium){
                    mediaPlayer.pause()
                }
            }
            else->{}
        }
    }

    private fun initializeMediaPlayer(){
        val audioUrl = "https://www.youtube.com/watch?v=U6cPjurCOmQ"
        mediaPlayer = MediaPlayer.create(context, R.raw.relax)

        }
    }


