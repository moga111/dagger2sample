package com.example.dagger2sample.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.example.dagger2sample.dagger.components.subcomponents.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        MainActivityComponent.class
})
public class ApplicationModule {
    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application;
    }
}
