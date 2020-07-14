package com.example.mylibrary.presenter

import dagger.BindsInstance

interface PresenterComponent {

    fun presenterDependency(): PresenterDependency

    interface Builder<Component : PresenterComponent> {

        @BindsInstance
        fun bindDefaultPresenterDependency(default: PresenterComponent? = null): Builder<Component>

        fun build(): Component
    }

    interface PresenterInjector<Builder> {
        fun getCreateOrEditBeneficiaryPresenterComponentBuilder(): Builder
    }
}
