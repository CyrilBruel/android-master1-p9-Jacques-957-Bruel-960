package com.example.android.config;

import com.example.android.classes.ResInscription;
import com.example.android.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://192.168.88.35:3000/";
    @POST("api/user")
    Call<ResInscription> inscription(@Body User dataModal);
    @POST("api/user/login")
    Call<ResInscription> login(@Body User dataModal);
}