package com.example.myapplication.router

import com.example.mylibrary.router.RouterDependency
import dagger.Binds
import dagger.Module

@Module
interface DefaultRouterModule {

    @Binds
    fun bindRouterDependency(defaultRouterDependencyImpl: DefaultRouterDependencyImpl): RouterDependency
}
