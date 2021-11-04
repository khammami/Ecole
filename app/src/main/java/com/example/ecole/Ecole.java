package com.example.ecole;

public class Ecole {
    private String nom;
    private String des;
    private int iconID;

    public Ecole(String nom, String des, int iconID) {
        this.nom = nom;
        this.des = des;
        this.iconID = iconID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}

