package com.example.dagger2sample.dagger.modules;

import com.example.dagger2sample.presenter.MainPresenter;
import com.example.dagger2sample.ui.MainActivity;
import com.example.dagger2sample.ui.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MainPresenter provideMainPresenter(MainView mainView) {
        return new MainPresenter(mainView);
    }
}
