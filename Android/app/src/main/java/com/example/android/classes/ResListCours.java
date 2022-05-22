package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResListCours extends Res{

    @SerializedName("data")
    ArrayList<Cours> listCours;

    public ArrayList<Cours> getListCours() {
        return listCours;
    }

    public void setListCours(ArrayList<Cours> listCours) {
        this.listCours = listCours;
    }

}
