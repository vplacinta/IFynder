package com.llc.ifynder;

import com.llc.ifynder.login.LoginComponent;
import com.llc.ifynder.login.LoginModule;
import com.llc.ifynder.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    LoginComponent add(LoginModule loginModule);
}
