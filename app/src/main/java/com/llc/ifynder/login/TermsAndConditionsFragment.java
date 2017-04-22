package com.llc.ifynder.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.llc.ifynder.R;
import com.llc.ifynder.ScreenNavigation;
import com.llc.ifynder.di.Injector;
import com.llc.ifynder.register.RegisterFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TermsAndConditionsFragment extends Fragment {

    @Inject
    ScreenNavigation screenNavigation;

    @OnClick(R.id.btn_cancel)
    void cancel(Button button) {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.btn_agree)
    void agree(Button button) {
        screenNavigation.switchFragment(RegisterFragment.newInstance(), R.id.login_container, true);
    }

    public static Fragment newInstance() {
        return new TermsAndConditionsFragment();
    }

    @BindView(R.id.tv_tnc_text)
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getLoginComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);
        ButterKnife.bind(this, view);
        textView.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
