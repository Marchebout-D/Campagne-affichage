package com.example.campagneaffichage.temporaire;

import java.util.ArrayList;

public class Secteur {
    private String libelle;
    private String statut;
    ArrayList<PI> ListePI;

    public Secteur(String libelle, ArrayList<PI> listePI) {
        this.libelle = libelle;
        ListePI = listePI;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public ArrayList<PI> getListePI() {
        return ListePI;
    }

    public void setListePI(ArrayList<PI> listePI) {
        ListePI = listePI;
    }
}
