package com.example.campagneaffichage.temporaire;

public class PI{
    private String nom;
    private String latitude;
    private String longitude;
    private String adresse;
    private String affiche;
    private String type;
    private String mode;

    public PI(String nom, String latitude,String longitude, String adresse, String affiche, String type,String mode) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.adresse = adresse;
        this.affiche = affiche;
        this.type = type;
        this.mode= mode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "PI{" +
                "nom='" + nom + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", adresse='" + adresse + '\'' +
                ", affiche='" + affiche + '\'' +
                ", type='" + type + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
