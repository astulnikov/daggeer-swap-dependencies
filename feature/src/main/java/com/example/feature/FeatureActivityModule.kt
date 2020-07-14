package com.example.feature

import com.example.mylibrary.presenter.PresenterComponent
import com.example.mylibrary.presenter.PresenterDependency
import dagger.Module
import dagger.Provides

@Module
class FeatureActivityModule {

    @Provides
    fun providePresenter(provider: PresenterComponent?): PresenterDependency =
        provider!!.presenterDependency()
}
