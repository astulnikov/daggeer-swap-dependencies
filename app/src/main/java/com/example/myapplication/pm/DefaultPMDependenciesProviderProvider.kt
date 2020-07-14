package com.example.myapplication.pm

import com.example.mylibrary.pm.PMDependenciesProvider
import com.example.mylibrary.router.RouterDependenciesProvider
import com.example.mylibrary.state.StateDependenciesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PMModule::class
    ],
    dependencies = [
        RouterDependenciesProvider::class,
        StateDependenciesProvider::class
    ]
)
interface DefaultPMDependenciesProviderProvider : PMDependenciesProvider {

    @Component.Factory
    interface Factory {

        fun create(
            routerDependenciesProvider: RouterDependenciesProvider,
            stateDependenciesProvider: StateDependenciesProvider
        ): DefaultPMDependenciesProviderProvider
    }
}
