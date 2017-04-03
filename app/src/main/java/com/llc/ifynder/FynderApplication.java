package com.llc.ifynder;

import android.app.Application;


public class FynderApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initApplicationComponent(this);
    }
}
