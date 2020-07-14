package com.example.feature.router

import com.example.mylibrary.router.RouterDependency
import dagger.Binds
import dagger.Module

@Module
interface FeatureRouterModule {

    @Binds
    fun bindCustomFlowDependency(flowDependency: FeatureRouterDependencyImpl): RouterDependency
}
