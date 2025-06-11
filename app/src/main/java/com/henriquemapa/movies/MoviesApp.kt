package com.henriquemapa.movies

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.henriquemapa.data.di.dataModule
import com.henriquemapa.domain.di.domainModule
import com.henriquemapa.presentation.di.presentationModule

class MoviesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoviesApp)
            modules(
                dataModule,
                domainModule,
                presentationModule,
            )
        }
    }
}