package com.llc.ifynder.network;


import com.llc.ifynder.login.BaseResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FynderRestAPI {

    @POST("login")
    Call<LoginResponse> login(@Header("Content-Type") String content_type,
                              @Body Map body);

    @POST("forgotpwd")
    Call<BaseResponse> forgotPassword(@Body Map body);

    @POST("adduser")
    Call<RegisterResponse> addUser(@Body Map body);
}
