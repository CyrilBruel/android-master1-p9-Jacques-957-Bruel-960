package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

public class ResInscription extends Res{

    @SerializedName("data")
    User user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
