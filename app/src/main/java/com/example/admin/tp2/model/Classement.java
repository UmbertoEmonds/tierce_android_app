package com.example.admin.tp2.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 19/12/2016.
 */

public class Classement implements Serializable{

    private int place;
    private String date;

    public int getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public Classement(int place, String date) {
        this.place = place;
        this.date = date;
    }

    public String afficherClassement(){

        return place + " / " + date;

    }

}
