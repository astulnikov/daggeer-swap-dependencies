package com.example.feature.presenter

import com.example.mylibrary.pm.PMDependency
import com.example.mylibrary.presenter.PresenterDependency
import com.example.mylibrary.router.RouterDependency
import javax.inject.Inject

class FeaturePresenterDependencyImpl @Inject constructor(
    private val routerDependency: RouterDependency,
    private val pmDependency: PMDependency
) : PresenterDependency {
    override fun run(): String =
        "$this It's the FeaturePresenterDependency +  pmDependency: \n ${pmDependency.run()} and routerDependency: \n ${routerDependency.run()} -  ${routerDependency.call()}"
}
