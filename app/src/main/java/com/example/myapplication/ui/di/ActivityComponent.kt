package com.example.myapplication.ui.di

import com.example.mylibrary.presenter.PresenterComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ActivityModule::class,
        ViewModule::class
    ]
)
interface ActivityComponent : PresenterComponent {

    @Subcomponent.Builder
    interface Builder : PresenterComponent.Builder<ActivityComponent>

    interface ActivityInjector : PresenterComponent.PresenterInjector<Builder>
}
