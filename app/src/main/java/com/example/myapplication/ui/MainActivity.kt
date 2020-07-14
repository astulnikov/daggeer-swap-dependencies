package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.DaggerFlowComponent
import com.example.myapplication.R
import com.example.myapplication.pm.DaggerDefaultPMDependenciesProviderProvider
import com.example.myapplication.router.DaggerDefaultRouterDependencyProviderProvider
import com.example.myapplication.state.DaggerDefaultStateDependencyProviderProvider
import com.example.mylibrary.presenter.PresenterDependency

class MainActivity : AppCompatActivity() {

    lateinit var presenterDependency: PresenterDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stateDependencyProvider = DaggerDefaultStateDependencyProviderProvider.create()
        val defaultRouterDependenciesProvider =
            DaggerDefaultRouterDependencyProviderProvider.factory().create(stateDependencyProvider)

        val routerDependenciesProvider =
            DaggerDefaultRouterDependencyProviderProvider.factory().create(
                stateDependencyProvider
            )

        val flowComponent = DaggerFlowComponent.builder()
            .stateDependenciesProvider(stateDependencyProvider)
            .routerDependenciesProvider(routerDependenciesProvider)
            .pMDependenciesProvider(
                DaggerDefaultPMDependenciesProviderProvider.factory()
                    .create(routerDependenciesProvider, stateDependencyProvider)
            )
            .build()

        presenterDependency =
            flowComponent.getCreateOrEditBeneficiaryPresenterComponentBuilder()
                .build()
                .presenterDependency()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "presenterDependency: ${presenterDependency.run()}")
    }
}
