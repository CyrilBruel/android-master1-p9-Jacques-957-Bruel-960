package com.example.android.classes;

public class Theme {
    private int serialNum;
    private String val;
    private String desce;
    public Theme(int num, String val, String desce) {
        this.serialNum = num;
        this.val = val;
        this.desce = desce;
    }
    public int getNum() {
        return serialNum;
    }
    public void setNum(int num) {
        this.serialNum = num;
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
