package com.llc.ifynder;

import android.app.Application;


public class FynderApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
