package com.example.admin.tp2.controller;


/**
 * Created by admin on 24/11/2016.
 */

public class Utils {

    public static void print(Object message){
        System.out.println(message);
    }

    public static int random(int min, int max){
        max += 1;
        return (int)Math.floor(min + (Math.random() * (max - min)));
    }

}
