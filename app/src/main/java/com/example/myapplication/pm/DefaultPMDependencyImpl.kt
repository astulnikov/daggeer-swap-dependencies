package com.example.myapplication.pm

import com.example.mylibrary.pm.PMDependency
import com.example.mylibrary.router.RouterDependency
import com.example.mylibrary.state.StateDependency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPMDependencyImpl @Inject constructor(
    private val routerDependency: RouterDependency,
    private val state: StateDependency
) : PMDependency {

    override fun run(): String =
        "$this It's DefaultPMDependencyImpl + routerDependency: \n ${routerDependency.run()} and state: \n ${state.run()}"
}
