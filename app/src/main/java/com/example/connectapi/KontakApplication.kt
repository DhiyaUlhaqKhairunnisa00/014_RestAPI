package com.example.connectapi

import android.app.Application
import com.example.connectapi.repository.AppContainer
import com.example.connectapi.repository.KontakContainer

class KontakAplication : Application() {
    /** AppControler instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}