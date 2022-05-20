package com.example.android.classes;

public class Theme {
    private int id;
    private String val;
    private String desce;
    public Theme(int num, String val, String desce) {
        this.id = num;
        this.val = val;
        this.desce = desce;
    }
    public int getId() {
        return id;
    }
    public void setId(int num) {
        this.id = num;
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
    public String getDesce() {
        return desce;
    }
    public void setDesce(String desce) {
        this.desce = desce;
    }
}
