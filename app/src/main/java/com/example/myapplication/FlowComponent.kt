package com.example.myapplication

import com.example.myapplication.ui.di.ActivityComponent
import com.example.mylibrary.pm.PMDependenciesProvider
import com.example.mylibrary.router.RouterDependenciesProvider
import com.example.mylibrary.state.StateDependenciesProvider
import dagger.Component

@Component(
    dependencies = [
        RouterDependenciesProvider::class,
        PMDependenciesProvider::class,
        StateDependenciesProvider::class
    ]
)
interface FlowComponent : ActivityComponent.ActivityInjector
