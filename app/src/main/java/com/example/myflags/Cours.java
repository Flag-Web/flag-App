package com.example.myflags;

public class Cours {
    private String codecours;
    private String description;
    public Cours(String nom,String description){
        this.codecours=nom;
        this.description=description;
    }
    public String getName(){
        return this.codecours;
    }
    public String getDescription(){
        return this.description;
    }
}
