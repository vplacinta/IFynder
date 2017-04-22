package com.llc.ifynder.register;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.llc.ifynder.R;
import com.llc.ifynder.ScreenNavigation;
import com.llc.ifynder.base.BaseFragment;
import com.llc.ifynder.di.Injector;
import com.llc.ifynder.network.FynderRestAPI;
import com.llc.ifynder.network.RegisterResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class RegisterFragment extends BaseFragment {
    private boolean passwordShown;
    @Inject
    ScreenNavigation screenNavigation;

    @Inject
    Context context;

    @Inject
    FynderRestAPI fynderRestAPI;

    @BindView(R.id.et_login_register)
    EditText loginTextView;

    @BindView(R.id.et_password_register)
    EditText passwordTextView;

    @BindView(R.id.btn_register)
    Button registerButton;

    @OnClick(R.id.tv_show_password)
    void showPassword(TextView textView) {
        if (isPasswordShown()) {
            setPasswordShown(false);
            textView.setText(R.string.show_password);
            textView.setTextColor(ContextCompat.getColor(context, R.color.orangeAccent));
            passwordTextView.setTransformationMethod(PasswordTransformationMethod.getInstance());
            passwordTextView.setSelection(passwordTextView.getText().length());
        } else {
            setPasswordShown(true);
            textView.setText(R.string.hide_password);
            textView.setTextColor(Color.WHITE);
            passwordTextView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            passwordTextView.setSelection(passwordTextView.getText().length());
        }
    }

    @OnClick(R.id.btn_register)
    void continueRegister(Button registerButton) {
        if (!isEmailValid(String.valueOf(loginTextView.getText()))) {
            Snackbar.make(getView(), "The Email ID is invalid", Snackbar.LENGTH_SHORT).show();
        } else if (!isPasswordValid(String.valueOf(passwordTextView.getText()))) {
            Snackbar.make(getView(), "The password is too short", Snackbar.LENGTH_SHORT).show();
        } else
            fynderRestAPI.addUser(getAddUserMap()).enqueue(new AddUserCallback());
            registerButton.setEnabled(false);
    }


    private Map getAddUserMap() {
        Map<String, String> map = new HashMap<>();
        map.put("email", String.valueOf(loginTextView.getText()));
        map.put("password", String.valueOf(passwordTextView.getText()));
        map.put("ref_code", "");
        map.put("refid", "0");
        return map;
    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getLoginComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }


    public boolean isPasswordShown() {
        return passwordShown;
    }

    public void setPasswordShown(boolean passwordShown) {
        this.passwordShown = passwordShown;
    }

    private boolean isPasswordValid(String s) {
        if (s.length() < 4)
            return false;
        else return true;
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }

    private class AddUserCallback implements retrofit2.Callback<RegisterResponse> {
        @Override
        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
            Snackbar.make(getView(), response.body().getMessage(), Snackbar.LENGTH_LONG).show();
            screenNavigation.switchFragment(RegisterProfileFragment.newInstance(),R.id.login_container,true);
            registerButton.setEnabled(true);
        }

        @Override
        public void onFailure(Call<RegisterResponse> call, Throwable t) {
            Snackbar.make(getView(), "Error", Snackbar.LENGTH_LONG).show();
            registerButton.setEnabled(false);
        }
    }


}
