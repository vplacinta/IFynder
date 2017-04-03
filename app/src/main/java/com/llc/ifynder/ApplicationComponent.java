package com.llc.ifynder;

import com.llc.ifynder.login.LoginFragment;
import com.llc.ifynder.login.RegisterFragment;
import com.llc.ifynder.login.TermsAndConditionsFragment;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginFragment target);
    void inject(RegisterFragment target);
    void inject(TermsAndConditionsFragment target);

}
