package com.example.admin.tp2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 15/12/2016.
 */

public class Cheval implements Serializable{

    private String nom;
    private int numero;
    private int age;
    private ArrayList<Classement> classement;
    private boolean isFavori;

    public Cheval(String nom, int numero, int age) {
        this.nom = nom;
        this.numero = numero;
        this.age = age;
        classement = new ArrayList<>();
    }

    public void addToClassement(int place, String date){
        classement.add(new Classement(place, date));
    }

    public boolean isFavori() {
        return isFavori;
    }

    public void setFavori(boolean favori) {
        isFavori = favori;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Classement> getClassement() {
        return classement;
    }

    @Override
    public String toString(){
        return nom + " / " + numero + " / " + age;
    }
}
