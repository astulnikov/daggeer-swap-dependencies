package com.example.feature.router

import com.example.mylibrary.OriginDependency
import com.example.mylibrary.router.RouterDependenciesProvider
import com.example.mylibrary.router.RouterDependency
import com.example.mylibrary.state.StateDependenciesProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FeatureRouterModule::class
    ],
    dependencies = [
        StateDependenciesProvider::class
    ]
)
interface FeatureRouterDependenciesProvider : RouterDependenciesProvider {

    @Component.Factory
    interface Factory {

        fun create(
            stateDependenciesProvider: StateDependenciesProvider,
            @BindsInstance @OriginDependency defaultRouterDependency: RouterDependency
        ): FeatureRouterDependenciesProvider
    }
}
