package com.example.admin.tp2.model;

import com.example.admin.tp2.controller.ChevalController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by admin on 15/12/2016.
 */

public class PMU {

    private static ArrayList<String> nom_chevaux = new ArrayList<>();
    private static ArrayList<Cheval> lesChevaux;

    public PMU(){

        nom_chevaux.add("Blonde");
        nom_chevaux.add("Ruby");
        nom_chevaux.add("Rituel 9");
        nom_chevaux.add("Royale");
        nom_chevaux.add("Brune");
        nom_chevaux.add("Jupiler");
        nom_chevaux.add("Kasteel");
        nom_chevaux.add("Rince Rochon");
        nom_chevaux.add("Cuvée");
        nom_chevaux.add("Coca");
        nom_chevaux.add("Pepsi");
        nom_chevaux.add("Monster");
        nom_chevaux.add("Ambrée");
        nom_chevaux.add("Sprite");
        nom_chevaux.add("7up");

    }

    private int getMaxChevaux(){
        return nom_chevaux.size();
    }

    // recevra la saisie utilisateur pour le nombre de chevaux saisis
    private ArrayList<Cheval> getChevaux(int count){

        // crée tout les chevaux une seule fois

        ArrayList<Cheval> result = new ArrayList<>();

        if(lesChevaux==null){

            lesChevaux = new ArrayList<>();

            for (int i = 0; i<getMaxChevaux(); i++){
                lesChevaux.add(new Cheval(nom_chevaux.get(i), i, new ChevalController().setRandomAge()));
            }
        }

        for (int i = 0; i<count; i++){
            result.add(lesChevaux.get(i));
        }

        return result;

    }

    // effectue le tirage
    private ArrayList<Cheval> tirage(int nConcurrents, int nGagnants){

        ArrayList<Cheval> result = new ArrayList<>();
        ArrayList<Cheval> concurrents = getChevaux(nConcurrents);

        int random;
        Random rand;

        if(nConcurrents<=3){

            nGagnants = nConcurrents;

        }

            for(int i = 0; i<nGagnants; i++){

                rand = new Random();
                random = rand.nextInt(concurrents.size());

                result.add(concurrents.get(random));
                concurrents.remove(random);


            }

        return result;

    }

    // spécialise en mode tierce, avec 3 gagnants
    public ArrayList<Cheval> tirageTierce(int nConcurrents){

        ArrayList<Cheval> resultat = tirage(nConcurrents, 3);

        gestionClassement(resultat);

        return resultat;

    }

    public void gestionClassement(ArrayList<Cheval> result){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateF = dateFormat.format(date);

        result.get(0).addToClassement(1, dateF);
        result.get(1).addToClassement(2, dateF);
        result.get(2).addToClassement(3, dateF);

    }

}
