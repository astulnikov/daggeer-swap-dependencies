package com.example.feature.router

import com.example.mylibrary.OriginDependency
import com.example.mylibrary.router.RouterDependency
import com.example.mylibrary.state.StateDependency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRouterDependencyImpl @Inject constructor(
    private val state: StateDependency,
    @OriginDependency defaultRouter: RouterDependency
) : RouterDependency by defaultRouter {

    override fun run(): String =
        "$this FeatureRouterDependencyImpl run() + state: \n ${state.run()}"
}
