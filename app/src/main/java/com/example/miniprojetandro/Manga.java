package com.example.miniprojetandro;

import java.io.Serializable;

public class Manga implements Serializable {
    private String titre;
    private String auteur;
    private  int nbDeTome;
    private float prix;
    private String theme;
    private Genre genre;

    public Manga(String titre, String auteur, int nbDeTome, float prix, String theme, Genre genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbDeTome = nbDeTome;
        this.prix = prix;
        this.theme = theme;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbDeTome() {
        return nbDeTome;
    }

    public void setNbDeTome(int nbDeTome) {
        this.nbDeTome = nbDeTome;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
