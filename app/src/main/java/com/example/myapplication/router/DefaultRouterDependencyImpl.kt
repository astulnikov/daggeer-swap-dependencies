package com.example.myapplication.router

import com.example.mylibrary.router.RouterDependency
import com.example.mylibrary.state.StateDependency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRouterDependencyImpl @Inject constructor(
    private val state: StateDependency
) : RouterDependency {

    override fun run(): String =
        "$this DefaultRouterDependencyImpl run() + state: \n ${state.run()}"

    override fun call(): String =
        "$this DefaultRouterDependencyImpl call() state: \n ${state.run()}"
}
