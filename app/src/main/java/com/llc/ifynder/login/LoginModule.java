package com.llc.ifynder.login;

import com.llc.ifynder.base.BaseModule;
import com.llc.ifynder.login.LoginActivity;

import dagger.Module;

@Module
public class LoginModule extends BaseModule {

    private LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        super(loginActivity);
        this.loginActivity = loginActivity;
    }
}
