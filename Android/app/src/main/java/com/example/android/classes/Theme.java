package com.example.android.classes;

public class Theme {
    private int id;
    private String icone;
    private String desce;
    public Theme(int num, String icone, String desce) {
        this.id = num;
        this.icone = icone;
        this.desce = desce;
    }
    public int getId() {
        return id;
    }
    public void setId(int num) {
        this.id = num;
    }
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public String getDesce() {
        return desce;
    }
    public void setDesce(String desce) {
        this.desce = desce;
    }
}
