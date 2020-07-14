package com.example.myapplication.ui.presenter

import com.example.myapplication.ui.View
import com.example.mylibrary.pm.PMDependency
import com.example.mylibrary.presenter.PresenterDependency
import com.example.mylibrary.router.RouterDependency
import com.example.mylibrary.state.StateDependency
import javax.inject.Inject

class PresenterDependencyImpl @Inject constructor(
    private val routerDependency: RouterDependency,
    private val pmDependency: PMDependency,
    private val stateDependency: StateDependency,
    private val view: View
) : PresenterDependency {
    override fun run(): String =
        "$this It's the PresenterDependencyImpl +  pmDependency: \n " +
                "${pmDependency.run()} and stateDependency: \n" +
                " ${stateDependency.run()} and routerDependency: \n " +
                "${routerDependency.run()} - ${routerDependency.call()} \n ${view.render()}"
}
