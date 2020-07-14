package com.example.myapplication.ui.di

import com.example.myapplication.ui.presenter.PresenterDependencyImpl
import com.example.mylibrary.presenter.PresenterDependency
import dagger.Binds
import dagger.Module

@Module
interface ActivityModule {

    @Binds
    fun bindPresenter(presenter: PresenterDependencyImpl): PresenterDependency
}
