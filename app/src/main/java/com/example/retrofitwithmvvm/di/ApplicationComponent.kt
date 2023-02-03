package com.example.retrofitwithmvvm.di

import android.content.Context
import com.example.retrofitwithmvvm.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,DataBaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):ApplicationComponent
    }

}