package com.example.feature

import com.example.mylibrary.presenter.PresenterComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [
        FeatureActivityModule::class
    ]
)
interface FeatureActivityComponent : PresenterComponent {

    @Subcomponent.Builder
    interface Builder : PresenterComponent.Builder<FeatureActivityComponent>

    interface ActivityInjector : PresenterComponent.PresenterInjector<Builder>
}
