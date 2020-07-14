package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.feature.DaggerFeatureFlowComponent
import com.example.feature.router.DaggerFeatureRouterDependenciesProvider
import com.example.myapplication.DaggerFlowComponent
import com.example.myapplication.R
import com.example.myapplication.pm.DaggerDefaultPMDependenciesProviderProvider
import com.example.myapplication.router.DaggerDefaultRouterDependencyProviderProvider
import com.example.myapplication.state.DaggerDefaultStateDependencyProviderProvider
import com.example.mylibrary.presenter.PresenterComponent
import com.example.mylibrary.presenter.PresenterDependency
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    lateinit var presenterDependency: PresenterDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val stateDependencyProvider = DaggerDefaultStateDependencyProviderProvider.create()
        val defaultRouterDependenciesProvider =
            DaggerDefaultRouterDependencyProviderProvider.factory().create(stateDependencyProvider)

        val routerDependenciesProvider =
            DaggerFeatureRouterDependenciesProvider.factory().create(
                stateDependencyProvider,
                defaultRouterDependenciesProvider.routerDependency
            )

        val flowComponent = DaggerFeatureFlowComponent.builder()
            .stateDependenciesProvider(stateDependencyProvider)
            .routerDependenciesProvider(routerDependenciesProvider)
            .pMDependenciesProvider(
                DaggerDefaultPMDependenciesProviderProvider.factory()
                    .create(routerDependenciesProvider, stateDependencyProvider)
            )
            .build()

        val defaultFlowComponent = DaggerFlowComponent.builder()
            .stateDependenciesProvider(stateDependencyProvider)
            .routerDependenciesProvider(routerDependenciesProvider)
            .pMDependenciesProvider(
                DaggerDefaultPMDependenciesProviderProvider.factory()
                    .create(routerDependenciesProvider, stateDependencyProvider)
            )
            .build()

        val injector =
            flowComponent as PresenterComponent.PresenterInjector<PresenterComponent.Builder<PresenterComponent>>
        presenterDependency =
            injector.getCreateOrEditBeneficiaryPresenterComponentBuilder()
                .bindDefaultPresenterDependency(
                    defaultFlowComponent.getCreateOrEditBeneficiaryPresenterComponentBuilder()
                        .build()
                )
                .build()
                .presenterDependency()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "presenterDependency: ${presenterDependency.run()}")
    }
}
