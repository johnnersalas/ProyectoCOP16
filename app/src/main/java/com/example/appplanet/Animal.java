package com.example.appplanet;

public class Animal {
    private String especie;
    private String animal;
    private String raza;
    private String grupo;
    private String info;
    private int fotoRedId;    //ID del recurso de la imágen
    private int sonidoResId;  //ID del recurso del sonido

    // Creamos el método constructor
    public Animal(String especie, String animal, String raza, String grupo, String info, int fotoRedId, int sonidoResId){
        this.especie = especie;
        this.animal = animal;
        this.raza = raza;
        this.grupo = grupo;
        this.info = info;
        this.fotoRedId = fotoRedId;
        this.sonidoResId = sonidoResId;
    }

    public String getEspecie() {
        return especie;
    }

    public String getAnimal() {
        return animal;
    }

    public String getRaza() {
        return raza;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getInfo(){
        return info;
    }

    public int getFotoRedId() {
        return fotoRedId;
    }

    public int getSonidoResId() {
        return sonidoResId;
    }
}
