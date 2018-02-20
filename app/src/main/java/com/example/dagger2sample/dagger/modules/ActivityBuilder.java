package com.example.dagger2sample.dagger.modules;

import android.app.Activity;

import com.example.dagger2sample.dagger.components.subcomponents.MainActivityComponent;
import com.example.dagger2sample.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(
            MainActivityComponent.Builder builder
    );
}
