package com.llc.ifynder;

import javax.inject.Inject;

public enum Injector {

    INSTANCE;

    ApplicationComponent applicationComponent;
    LoginComponent loginComponent;

    Injector(){

    }

    public void initApplicationComponent(FynderApplication fynderApplication){
        if (applicationComponent == null){
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(fynderApplication))
                    .build();
        }
    }

    public void initLoginComponent(LoginActivity loginActivity) {
        if (loginComponent == null) {
            loginComponent = getApplicationComponent().add(new LoginModule(loginActivity));
        }
        loginComponent.inject(loginActivity);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public LoginComponent getLoginComponent(){
        return loginComponent;
    }

    public void releaseLoginComponent(){
        loginComponent = null;
    }
}
