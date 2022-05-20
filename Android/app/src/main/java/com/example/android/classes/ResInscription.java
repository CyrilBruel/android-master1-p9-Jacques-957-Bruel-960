package com.example.android.classes;

import com.google.gson.annotations.SerializedName;

public class ResInscription {
    @SerializedName("status")
    String status;
    @SerializedName("data")
    User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
