package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResDetailCours extends Res{
    @SerializedName("data")
    ArrayList<DetailCours> listCours;

    public ArrayList<DetailCours> getListCours() {
        return listCours;
    }

    public void setListCours(ArrayList<DetailCours> listCours) {
        this.listCours = listCours;
    }
}
