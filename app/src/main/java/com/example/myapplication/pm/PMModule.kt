package com.example.myapplication.pm

import com.example.mylibrary.pm.PMDependency
import dagger.Binds
import dagger.Module

@Module
interface PMModule {

    @Binds
    fun bindChildDependency(dependencyImplImpl: DefaultPMDependencyImpl): PMDependency
}
