package com.example.android.config;

import com.example.android.classes.BodyListCours;
import com.example.android.classes.ResDetailCours;
import com.example.android.classes.ResGetCategorie;
import com.example.android.classes.ResInscription;
import com.example.android.classes.ResListCours;
import com.example.android.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "http://192.168.88.16:3000/";
    @POST("api/user")
    Call<ResInscription> inscription(@Body User dataModal);
    @POST("api/user/login")
    Call<ResInscription> login(@Body User dataModal);
    @GET("api/categorie")
    Call<ResGetCategorie> getCategories();
    @POST("api/cours")
    Call<ResListCours> listCours(@Body BodyListCours dataModal);
    @GET("/api/detailscours/{iduser}/{idcours}")
    Call<ResDetailCours> getCours(@Path("iduser") String iduser, @Path("idcours") String idCours);
}