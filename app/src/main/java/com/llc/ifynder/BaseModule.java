package com.llc.ifynder;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {
    private BaseActivity baseActivity;

    public BaseModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    public ScreenNavigation providesScreenNavigation(){
        return new ScreenNavigation(baseActivity.getSupportFragmentManager());
    }
}
