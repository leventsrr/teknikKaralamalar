package com.leventsurer.lifecycleawareclasscase

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {

    lateinit var counterComponentClass: CounterComponentClass
    lateinit var focusMusicComponent: FocusMusicComponent
    lateinit var counterText : TextView
    lateinit var deactiveCounterText : TextView
    lateinit var isUserPremiumSwitch : SwitchCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        counterText = findViewById(R.id.tvCounterText)
        deactiveCounterText = findViewById(R.id.tvDeactiveCount)
        isUserPremiumSwitch = findViewById(R.id.swIsPremiumUser)

        isUserPremiumSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
           focusMusicComponent.changeUserPremiumStatus(isChecked)
        }

        initializeComponents()

        counterComponentClass.counter.observe(this){ count->
            counterText.text = count.toString()
        }

        counterComponentClass.appDeactivetedCounter.observe(this){ deActiveCount->
            deactiveCounterText.text = deActiveCount.toString()
        }



    }

    private fun initializeComponents() {
        counterComponentClass = CounterComponentClass()
        focusMusicComponent = FocusMusicComponent(context = applicationContext)
        lifecycle.addObserver(counterComponentClass)
        lifecycle.addObserver(focusMusicComponent)
        focusMusicComponent.changeUserPremiumStatus(false)
    }
}