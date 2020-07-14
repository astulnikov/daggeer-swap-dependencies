package com.example.myapplication.state

import com.example.mylibrary.state.StateDependenciesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        StateModule::class
    ]
)
interface DefaultStateDependencyProviderProvider : StateDependenciesProvider
