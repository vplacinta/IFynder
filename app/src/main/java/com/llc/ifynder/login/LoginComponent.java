package com.llc.ifynder.login;

import com.llc.ifynder.register.RegisterFragment;
import com.llc.ifynder.register.RegisterProfileFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity target);
    void inject(LoginFragment target);
    void inject(TermsAndConditionsFragment target);
    void inject(RegisterFragment target);
    void inject(RegisterProfileFragment target);
}
