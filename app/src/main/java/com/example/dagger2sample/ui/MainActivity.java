package com.example.dagger2sample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dagger2sample.R;
import com.example.dagger2sample.presenter.MainPresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.onCreate();
    }

    @Override
    public void showTestLog() {
        Log.d("MainActivity", "showTestLog()");
    }
}
