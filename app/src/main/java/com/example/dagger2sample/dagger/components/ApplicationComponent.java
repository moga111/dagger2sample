package com.example.dagger2sample.dagger.components;

import android.app.Application;

import com.example.dagger2sample.MainApplication;
import com.example.dagger2sample.dagger.modules.ActivityBuilder;
import com.example.dagger2sample.dagger.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ActivityBuilder.class,
        ApplicationModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {
    void inject(MainApplication mainApplication);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application app);
        ApplicationComponent build();
    }
}
