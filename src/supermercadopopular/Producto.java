/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercadopopular;

import java.util.Scanner;

/**
 *
 * @author jimer.sayago
 */
public class Producto{

    private String codigo;
    private String descripcion;
    private int cantProductos;
    private double costoCompra;
    private double precioVenta;

    Scanner entrada = new Scanner(System.in);

    public Producto() {
        codigo = "";
        descripcion = "";
        cantProductos = 0;
        costoCompra = 0.0;
        precioVenta = 0.0;
    }

    public Producto(String codigo, String descripcion, int cantProductos, double costoCompra, double precioVenta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantProductos = cantProductos;
        this.costoCompra = costoCompra;
        this.precioVenta = precioVenta;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getCodigo(int i) {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    public void leerDatos() {
        System.out.println("Ingrese el codigo del producto: ");
        codigo = entrada.nextLine();
        entrada.nextLine();
        System.out.println("Nombre del producto a agregar: ");
        descripcion = entrada.nextLine();
        entrada.nextLine();
        System.out.println("Ingrese el costo de compra del producto (expreselo con coma): ");
        costoCompra = entrada.nextDouble();
        System.out.println("Ingrese el precio de venta del producto (expreselo con coma): ");
        precioVenta = entrada.nextDouble();
        System.out.println("Ingrese cuantos productos de " + descripcion + " deseas agregar al almacen: ");
        cantProductos = entrada.nextInt();
    }

}
