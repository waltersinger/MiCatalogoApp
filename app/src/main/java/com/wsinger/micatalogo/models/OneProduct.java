package com.wsinger.micatalogo.models;

public class OneProduct {
    private String codigArticulo;
    private String articulo;
    private String imagen;
    private double precio;
    private double cantidad;

    public OneProduct(String codigArticulo, String articulo, String imagen, double precio) {
        this.codigArticulo = codigArticulo;
        this.articulo = articulo;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = 1;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCodigArticulo() {
        return codigArticulo;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public void incCantidad(double cantidad){
        this.cantidad += cantidad;
    }
}
