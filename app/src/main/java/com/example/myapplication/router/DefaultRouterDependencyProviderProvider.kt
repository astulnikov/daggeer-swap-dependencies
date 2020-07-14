package com.example.myapplication.router

import com.example.mylibrary.router.RouterDependenciesProvider
import com.example.mylibrary.state.StateDependenciesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DefaultRouterModule::class
    ],
    dependencies = [
        StateDependenciesProvider::class
    ]
)
interface DefaultRouterDependencyProviderProvider : RouterDependenciesProvider {

    @Component.Factory
    interface Factory {

        fun create(stateDependenciesProvider: StateDependenciesProvider): DefaultRouterDependencyProviderProvider
    }
}
