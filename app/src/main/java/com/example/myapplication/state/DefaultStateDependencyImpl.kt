package com.example.myapplication.state

import com.example.mylibrary.state.StateDependency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultStateDependencyImpl @Inject constructor() : StateDependency {
    override fun run(): String = "$this It's DefaultStateDependencyImpl"
}
