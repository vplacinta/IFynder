package com.llc.ifynder.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.llc.ifynder.network.FynderRestAPI;
import com.llc.ifynder.R;
import com.llc.ifynder.ScreenNavigation;
import com.llc.ifynder.base.BaseFragment;
import com.llc.ifynder.di.Injector;
import com.llc.ifynder.network.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends BaseFragment {

    @Inject
    ScreenNavigation screenNavigation;

    @Inject
    FynderRestAPI fynderRestAPI;

    @BindView(R.id.et_login)
    TextView loginTextView;

    @BindView(R.id.et_password)
    TextView passwordTextView;

    @OnClick(R.id.tv_register)
    void register(TextView textView) {
        screenNavigation.switchFragment(TermsAndConditionsFragment.newInstance(), R.id.login_container, true);
    }

    @OnClick(R.id.tv_login)
    void login(TextView textView) {
        if (validateFields())
            fynderRestAPI.login("text/plain", getLoginMap()).enqueue(new LoginCallBack());
    }

    @OnClick(R.id.tv_forgot_password)
    void forgotPassword(TextView textView){
        Map<String, String> map = new HashMap<>();
        map.put("email", String.valueOf(loginTextView.getText()));
        fynderRestAPI.forgotPassword(map).enqueue(new ForgotPasswordCallback());
    }

    private boolean validateFields() {
        return true;
    }

    private Map getLoginMap() {
        Map<String, String> map = new HashMap<>();
        map.put("email", String.valueOf(loginTextView.getText()));
        map.put("password", String.valueOf(passwordTextView.getText()));
        map.put("phonetype", "1");
        map.put("pushtoken", "C4BF92BCC5AEC376D6A733B46F0C1823C35004DC3A2F638989DD0E87F37C43E0");

        return map;
    }


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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    private class LoginCallBack implements Callback<LoginResponse> {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            Snackbar.make(getView(), response.body().getMessage(), Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            Log.i("Response", "Failure");
        }
    }

    private class ForgotPasswordCallback implements Callback<BaseResponse> {

        @Override
        public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
            Snackbar.make(getView(), response.body().getMessage(), Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call<BaseResponse> call, Throwable t) {
            Snackbar.make(getView(), "Error", Snackbar.LENGTH_LONG).show();
        }
    }



}
