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
public class Lacteos extends Producto{
    /*private int cantLacteo;
    private String tipo;*/

    public Lacteos() {
        /*cantLacteo = 0;
        tipo = ""; */
    }

    public Lacteos(String codigo, String descripcion, int cantProductos, double costoCompra, double precioVenta) {
        super(codigo, descripcion, cantProductos, costoCompra, precioVenta);
        /*this.cantLacteo = cantLacteo;
        this.tipo = tipo;*/
    }
    
}
