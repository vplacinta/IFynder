package com.llc.ifynder.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llc.ifynder.BaseFragment;
import com.llc.ifynder.Injector;
import com.llc.ifynder.R;

import butterknife.ButterKnife;

public class LoginFragment extends BaseFragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getLoginComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        setUnbinder(ButterKnife.bind(this,view));
        return view;
    }
}
