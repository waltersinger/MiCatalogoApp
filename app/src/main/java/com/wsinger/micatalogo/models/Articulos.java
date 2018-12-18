package com.wsinger.micatalogo.models;

public class Articulos {

    private int id;
    private String articulo;
    private String imagen;
    private double costo;
    private int id_categoria;
    private double cantidad;
    private int calificacion;
    private String descripcion;



    public Articulos(int id, String articulo, String imagen, double costo, int id_categoria, double cantidad, int calificacion, String descripcion) {
        this.id = id;
        this.articulo = articulo;
        this.imagen = imagen;
        this.costo = costo;
        this.id_categoria = id_categoria;
        this.cantidad = cantidad;
        this.calificacion = calificacion;
        this.descripcion  = descripcion;
    }

    public Articulos(String articulo, double costo, String descripcion) {
        this.articulo = articulo;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public String getArticulo() {
        return articulo;
    }

    public String getImagen() {
        return imagen;
    }

    public double getCosto() {
        return costo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public double getCantidad() {
        return cantidad;
    }

    public int getCalificacion() {
        return calificacion;
    }
}
