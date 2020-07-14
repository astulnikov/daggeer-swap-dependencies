package com.example.myapplication.ui.di

import com.example.myapplication.ui.View
import com.example.myapplication.ui.ViewImpl
import dagger.Binds
import dagger.Module

@Module
interface ViewModule {

    @Binds
    fun bindView(view: ViewImpl): View
}
