package com.example.myapplication;
import java.io.Serializable;

public class Imobil implements Serializable {
    private String adresa;
    private double pret;
    private boolean esteDeVanzare;
    private String tipImobil;
    private String moneda;
    private float notaZona;

    public Imobil(String adresa, double pret, boolean esteDeVanzare, String tipImobil, String moneda, float notaZona) {
        this.adresa = adresa;
        this.pret = pret;
        this.esteDeVanzare = esteDeVanzare;
        this.tipImobil = tipImobil;
        this.moneda = moneda;
        this.notaZona = notaZona;
    }
    public String getAdresa() {
        return adresa;
    }

    @Override
    public String toString(){
        return "Imobil: " + adresa + " | Tip: " + tipImobil +
                " | Pret: " + pret + " " + moneda +
                " | De vanzare: " + (esteDeVanzare ? "Da" : "Nu") +
                " | Rating zona: " + notaZona + "/5";
    }

}


