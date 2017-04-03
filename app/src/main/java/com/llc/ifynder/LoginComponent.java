package com.llc.ifynder;

import com.llc.ifynder.login.LoginFragment;
import com.llc.ifynder.login.RegisterFragment;
import com.llc.ifynder.login.TermsAndConditionsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity target);
    void inject(LoginFragment target);
    void inject(TermsAndConditionsFragment target);
    void inject(RegisterFragment target);
}
