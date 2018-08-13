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
public class Carnes extends Producto{
    //private int cantKg;

    public Carnes() {
        //cantKg = 0;
    }

    public Carnes(String codigo, String descripcion, int cantProductos, double costoCompra, double precioVenta) {
        super(codigo, descripcion, cantProductos, costoCompra, precioVenta);
        //this.cantKg = cantKg;
    }

    /*public int getCantKg() {
        return cantKg;
    }*/

    
}
