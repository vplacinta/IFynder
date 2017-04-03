package com.llc.ifynder;

import android.os.Bundle;
import android.view.Window;

import com.llc.ifynder.login.LoginFragment;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    ScreenNavigation screenNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.initLoginComponent(this);
        screenNavigation.switchFragment(LoginFragment.newInstance(),R.id.login_container,false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

}
