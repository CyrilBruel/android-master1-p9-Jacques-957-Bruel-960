package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

public class BodyListCours {
    @SerializedName("iduser")
    String idUser;
    @SerializedName("idcategorie")
    int idCategorie;
    @SerializedName("age")
    int age;
    @SerializedName("search")
    String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
