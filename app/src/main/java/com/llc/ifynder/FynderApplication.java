package com.llc.ifynder;

import android.app.Application;

import com.llc.ifynder.di.Injector;


public class FynderApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initApplicationComponent(this);
    }
}
