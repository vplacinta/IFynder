package com.llc.ifynder;

import dagger.Module;

@Module
public class LoginModule extends BaseModule {
    private LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        super(loginActivity);
        this.loginActivity = loginActivity;
    }
}
