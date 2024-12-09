package com.example.miniprojetandro;

import java.io.Serializable;

public class Genre implements Serializable {
    private String libGenre;

    public Genre(String libGenre) {
        this.libGenre = libGenre;
    }

    public String getLibGenre() {
        return libGenre;
    }

    public void setLibGenre(String libGenre) {
        this.libGenre = libGenre;
    }
}
