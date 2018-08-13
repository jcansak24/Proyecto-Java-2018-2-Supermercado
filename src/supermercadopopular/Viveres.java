/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercadopopular;

/**
 *
 * @author jimer.sayago
 */
public class Viveres extends Producto{
    private String marca;

    public Viveres() {
        marca = "";
    }

    public Viveres(String marca, String codigo, String descripcion, int cantProductos, double costoCompra, double precioVenta) {
        super(codigo, descripcion, cantProductos, costoCompra, precioVenta);
        //this.cantUnidades = cantUnidades;
        this.marca = marca;
    }

    /*public int getCantUnidades() {
        return cantUnidades;
    }*/

    public String getMarca() {
        return marca;
    }

}
