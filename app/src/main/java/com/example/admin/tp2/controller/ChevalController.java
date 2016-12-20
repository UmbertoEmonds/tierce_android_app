package com.example.admin.tp2.controller;

import com.example.admin.tp2.model.Cheval;

/**
 * Created by admin on 15/12/2016.
 */

public class ChevalController {

    public int setRandomAge(){
        int age = Utils.random(0, 15);

        return age;
    }

}
