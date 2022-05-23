package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

public class BodyCoursUser {
    @SerializedName("iduser")
    String idUser;

    @SerializedName("age")
    int age;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
