/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercadopopular;

import java.util.ArrayList;

/**
 *
 * @author jimer.sayago
 */
public class Factura {
    String cedula;
    ArrayList <String> productoVender;
    ArrayList <Integer> cantProducts;
    double precioTotal;
    Producto []p;
    
    public Factura(){
        cedula = "";
        productoVender = new ArrayList<String>();
        cantProducts = new ArrayList<Integer>();
        precioTotal = 0.0;
        p = null;
    }

    public Factura(String cedula, ArrayList <String> productoVender, ArrayList <Integer> cantProducts, double precioTotal) {
        this.cedula = cedula;
        this.productoVender = productoVender;
        this.cantProducts = cantProducts;
        this.precioTotal = precioTotal;
        //this.p = p;
    }

    public String getCedula() {
        return cedula;
    }

    public String getProductoVender() {
        for (String productos : productoVender) {
            return productos;
        }
        return null;
    }

    public int getCantProducts() {
        for (int numProd : cantProducts) {
            return numProd;
        }
        return 0;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }
}
