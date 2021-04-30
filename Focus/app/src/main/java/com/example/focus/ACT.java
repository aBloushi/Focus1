package com.example.focus;

import java.io.Serializable;
import java.util.ArrayList;

public class ACT implements Serializable {

    String Acti;
    int sec;
    int min;

    public ACT(String acti, int sec, int min) {
        Acti = acti;
        this.sec = sec;
        this.min = min;

    }



    public String getActi() {
        return Acti;
    }

    public void setActi(String acti) {
        Acti = acti;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }


}
