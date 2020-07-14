package com.example.myapplication.ui

import javax.inject.Inject

class ViewImpl @Inject constructor() : View {

    override fun render(): String = "ViewImpl render()"
}
