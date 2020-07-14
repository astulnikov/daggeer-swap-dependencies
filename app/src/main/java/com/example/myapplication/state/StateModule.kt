package com.example.myapplication.state

import com.example.mylibrary.state.StateDependency
import dagger.Binds
import dagger.Module

@Module
interface StateModule {

    @Binds
    fun bindChildDependency(anotherDependencyImpl: DefaultStateDependencyImpl): StateDependency
}
