package org.example.exercice_apirest_voiture;

public class Voiture {
    private int id;
    private String marque;
    private String anneeFabrication;
    private String couleur;

    public Voiture() {
    }

    public Voiture(int id, String marque, String anneeFabrication, String couleur) {
        this.id = id;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getAnneeFabrication() {
        return anneeFabrication;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setAnneeFabrication(String anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
