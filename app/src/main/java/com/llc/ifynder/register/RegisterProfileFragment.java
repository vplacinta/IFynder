package com.llc.ifynder.register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.llc.ifynder.R;
import com.llc.ifynder.ScreenNavigation;
import com.llc.ifynder.base.BaseFragment;
import com.llc.ifynder.di.Injector;
import com.llc.ifynder.network.FynderRestAPI;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterProfileFragment extends BaseFragment {
    private boolean passwordShown;
    @Inject
    ScreenNavigation screenNavigation;

    @Inject
    Context context;

    @Inject
    FynderRestAPI fynderRestAPI;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getLoginComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_profile, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }


    public static RegisterProfileFragment newInstance() {
        return new RegisterProfileFragment();
    }
}