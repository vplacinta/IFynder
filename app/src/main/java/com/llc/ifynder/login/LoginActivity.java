package com.llc.ifynder.login;

import android.os.Bundle;

import com.llc.ifynder.R;
import com.llc.ifynder.ScreenNavigation;
import com.llc.ifynder.base.BaseActivity;
import com.llc.ifynder.di.Injector;
import com.llc.ifynder.login.LoginFragment;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    ScreenNavigation screenNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.initLoginComponent(this);
        screenNavigation.switchFragment(LoginFragment.newInstance(), R.id.login_container,false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

}
