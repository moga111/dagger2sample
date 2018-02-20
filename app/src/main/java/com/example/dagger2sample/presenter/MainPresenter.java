package com.example.dagger2sample.presenter;

import com.example.dagger2sample.ui.MainView;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void onCreate() {
        mainView.showTestLog();
    }
}
