package com.example.dagger2sample.dagger.components.subcomponents;

import com.example.dagger2sample.dagger.modules.MainActivityModule;
import com.example.dagger2sample.ui.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
