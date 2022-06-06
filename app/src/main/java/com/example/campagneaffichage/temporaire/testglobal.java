package com.example.campagneaffichage.temporaire;

import android.app.Application;

import java.util.ArrayList;

public class testglobal extends Application {
    ArrayList<PI>  listePi= new ArrayList<PI>();
    ArrayList<Secteur> ListeSecteur= new ArrayList<Secteur>();
    int nbPI = 0;
    int nbSect = 0;
    Secteur SecteurChoisi;
    public ArrayList<PI> getListePi() {
        return listePi;
    }
    public  PI getUnPi(int index){
        return listePi.get(index);
    }

    public int getNbPI() {
        return nbPI;
    }

    public Secteur getSecteurChoisi() {
        return SecteurChoisi;
    }

    public void setSecteurChoisi(Secteur secteurChoisi) {
        SecteurChoisi = secteurChoisi;
    }

    public int getNbSect() {
        return nbSect;
    }

    public void addListePi(PI unPi) {
        this.listePi.add(unPi);
        nbPI=nbPI+1;
    }

    public ArrayList<Secteur> getListeSecteur() {
        return ListeSecteur;
    }

    public void addListeSecteur(Secteur unSecteur) {
        this.ListeSecteur.add(unSecteur);
        nbSect=nbSect+1;
    }

}
