package com.example.musicatpsit;

public class Brano {
    private String titolo;
    private String autore;
    private String genere;


    public Brano(String titolo, String autore, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
    }
    public Brano(Brano brano) {
        this.titolo = brano.getTitolo();
        this.autore = brano.getAutore();
        this.genere = brano.getGenere();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
