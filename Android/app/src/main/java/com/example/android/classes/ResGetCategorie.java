package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResGetCategorie extends Res{

    @SerializedName("data")
    ArrayList<Theme> listTheme;

    public ArrayList<Theme> getListTheme() {
        return listTheme;
    }

    public void setListTheme(ArrayList<Theme> listTheme) {
        this.listTheme = listTheme;
    }
}

