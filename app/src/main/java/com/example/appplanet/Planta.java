package com.example.appplanet;

public class Planta {
    private String categoria;
    private String nombreComun;
    private String nombreCientifico;
    private String color;
    private String descripcion;
    private int imagen;


    public Planta(String categoria, String nombreComun, String nombreCientifico, String color, String descripcion, int imagen) {
        this.categoria = categoria;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.color = color;
        this.descripcion = descripcion;
        this.imagen = imagen;

    }

    // Getters y setters
    public String getCategoria() { return categoria; }
    public String getNombreComun() { return nombreComun; }
    public String getNombreCientifico() { return nombreCientifico; }
    public String getColor() { return color; }
    public String getDescripcion() { return descripcion; }
    public int getImagen() { return imagen; }

}

