package com.wsinger.micatalogo.models;

import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<OneProduct> products;
    private double total;


    private static final ShoppingCart ourInstance = new ShoppingCart();

    public static ShoppingCart getInstance() {
        return ourInstance;
    }

    private ShoppingCart() {
        this.products = new ArrayList<>();
        this.total = 0f;
    }

    public void addProduct(OneProduct oneProduct){
        boolean sameP = false;
        for (OneProduct p: products) {
            if(p.getCodigArticulo().equals(oneProduct.getCodigArticulo())){
                p.incCantidad(1);
                sameP =true;
                break;
            }
        }
        if(!sameP){
            products.add(oneProduct);
        }

        this.total = refreshTotal();
    }

    public  void removeProduct(OneProduct oneProduct){
        products.remove(oneProduct);
        this.total = refreshTotal();
    }

    private double refreshTotal(){
        double newTotal=0;
        for (OneProduct p: products) {
            newTotal += p.getCantidad() * p.getPrecio();
        }
        return newTotal;
    }

    public double getTotal() {
        return total;
    }
}
