package com.example.retrofitwithmvvm.application

import android.app.Application
import com.example.retrofitwithmvvm.di.ApplicationComponent
import com.example.retrofitwithmvvm.di.ApplicationModule
import com.example.retrofitwithmvvm.di.DaggerApplicationComponent


class MainApplication:Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

      applicationComponent= DaggerApplicationComponent.factory().create(this)
    }

}