package com.example.musicatpsit;

import java.util.ArrayList;

public class GestioneBrano {
    private ArrayList<Brano> brani = new ArrayList<Brano>();

    public GestioneBrano() {
    }

    public boolean inserisciBrano(Brano b){
        try{
            brani.add(new Brano(b));
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean inserisciBrano(String titolo, String autore, String genere){
        try{
            brani.add(new Brano(titolo, autore, genere));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public Brano searchBrano(String titolo, String autore, String genere){
        for(int i = 0; i< brani.size();i++){
            if(brani.get(i).getAutore().equals(autore) && brani.get(i).getGenere().equals(genere) && brani.get(i).getTitolo().equals(titolo)){
                return brani.get(i);
            }
        }
        return new Brano("", "", "");
    }

    public String visualizzaTitoli(){
        StringBuilder sbBrani = new StringBuilder();
        for (int i = 0;i<brani.size();i++){
            sbBrani.append(brani.get(i).getTitolo().toString()+"-");
            sbBrani.append(brani.get(i).getAutore().toString()+"\n");
        }
        return sbBrani.toString();
    }
}
