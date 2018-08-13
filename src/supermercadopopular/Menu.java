/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercadopopular;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author jimer.sayago
 */
public class Menu implements Datos {

    Scanner entrada = new Scanner(System.in);
    private int opc;
    private String marcaProducto;
    String cod;
    Producto prod;
    Producto[] p;
    ArrayList<Factura> f = new ArrayList<Factura>();
    int tam = 0;
    StringTokenizer tokens;
    ArrayList<String> productoVendido = new ArrayList<String>();
    ArrayList<Integer> cantProdVendidos = new ArrayList<Integer>();

    public Menu() {
        menu();
        p = new Producto[datosProductos.length];
    }

    public void menu() {
        System.out.println("Bienvenidos al Supermercado La Popular");
        System.out.println("¿Que Desea realizar?");
        System.out.println("1) Agregar Producto al almacen");
        System.out.println("2) Modificar existencia de un producto");
        System.out.println("3) Facturar Venta");
        System.out.println("4) Ingresos Brutos");
        System.out.println("5) Egresos de la empresa");
        System.out.println("6) Reporte exentos mayores ventas");
        System.out.println("7) Reporte productos existencia baja");
        System.out.println("8) Salir");
        System.out.println("introduzca opcion a escoger: ");
        opc = entrada.nextInt();
        do {
            if (opc < 1 && opc > 8) {
                System.err.println("La opcion introducida no es valida. Por favor Introduzca un numero que este dentro del rango establecido (1-8)");
                opc = entrada.nextInt();
            }
        } while (opc < 1 && opc > 8);
        cargarProductos();
        switch (opc) {
            case 1:
                agregarProducto();
                break;

            case 2:
                modificarProducto();
                break;

            case 3:
                facturarVenta();
                break;

            case 4:
                ingresosBrutos();
                break;

            case 5:
                egresosDeLaEmpresa();
                break;

            case 6:
                reporteExentosMayoresVentas();
                break;

            case 7:
                reporteProductosExistenciaBaja();
                break;

            case 8:
                System.out.println("Gracias por confiar en nuestros servicios. Vuelva Pronto!!!");
                System.exit(0);
                break;
        }
    }

    public void cargarProductos() {
        String codigo;
        String descripcion;
        String marca;
        double costoCompra;
        double precioVenta;
        int cantProductos;
        int tipo;

        p = new Producto[datosProductos.length + 20];
        for (int i = 0; i < datosProductos.length; i++) {
            tokens = new StringTokenizer(datosProductos[i], "-");
            tipo = Integer.parseInt(tokens.nextToken());
            codigo = tokens.nextToken();
            descripcion = tokens.nextToken();

            costoCompra = Double.parseDouble(tokens.nextToken());
            precioVenta = Double.parseDouble(tokens.nextToken());
            cantProductos = Integer.parseInt(tokens.nextToken());
            if (tipo == 1) {
                marca = tokens.nextToken();
                p[i] = new Enlatados(marca, codigo, descripcion, cantProductos, costoCompra, precioVenta);
                //System.out.println("codigo: "+p[i].getCodigo()+"\ndescripcion: "+p[i].getDescripcion()+"\nMarca: "+marca+"\nCosto: "+p[i].getCostoCompra()+"\nPrecio: "+p[i].getPrecioVenta()+"\nCantidada de productos: "+p[i].getCantProductos());
            }
            if (tipo == 2) {
                p[i] = new Lacteos(codigo, descripcion, cantProductos, costoCompra, precioVenta);
                //System.out.println("codigo: "+p[i].getCodigo()+"\ndescripcion: "+p[i].getDescripcion()+"\nCosto: "+p[i].getCostoCompra()+"\nPrecio: "+p[i].getPrecioVenta()+"\nCantidada de productos: "+p[i].getCantProductos());
            }
            if (tipo == 3) {
                p[i] = new Carnes(codigo, descripcion, cantProductos, costoCompra, precioVenta);
                //System.out.println("codigo: "+p[i].getCodigo()+"\ndescripcion: "+p[i].getDescripcion()+"\nCosto: "+p[i].getCostoCompra()+"\nPrecio: "+p[i].getPrecioVenta()+"\nCantidada de productos: "+p[i].getCantProductos());
            }
            if (tipo == 4) {
                marca = tokens.nextToken();
                p[i] = new Viveres(marca, codigo, descripcion, cantProductos, costoCompra, precioVenta);
                //System.out.println("codigo: "+p[i].getCodigo()+"\ndescripcion: "+p[i].getDescripcion()+"\nMarca: "+marca+"\nCosto: "+p[i].getCostoCompra()+"\nPrecio: "+p[i].getPrecioVenta()+"\nCantidada de productos: "+p[i].getCantProductos());       
            }
        }
    }

    public void agregarProducto() {
        int cont = 0;
        String tipoProducto;
        String resp;
        prod = new Producto();
        String codigoNuevo;

        /*for (int i = 0; i < datosProductos.length; i++) {
            System.out.println(" " + p[i].getCodigo());
        }*/
        do {
            System.out.println("Tipo de producto a ser agregado?: Enlatados/Lacteos/Carnes/viveres");
            entrada.nextLine();
            tipoProducto = entrada.nextLine();

            if (tipoProducto.compareToIgnoreCase("Enlatados") == 0) {
                prod.leerDatos();
                System.out.println("Ingrese la marca del producto: ");
                marcaProducto = entrada.nextLine();
                p[datosProductos.length + cont] = new Enlatados(marcaProducto, prod.getCodigo(), prod.getDescripcion(), prod.getCantProductos(), prod.getCostoCompra(), prod.getPrecioVenta());
            } else {
                if (tipoProducto.compareToIgnoreCase("Lacteos") == 0) {
                    prod.leerDatos();
                    p[datosProductos.length + cont] = new Lacteos(prod.getCodigo(), prod.getDescripcion(), prod.getCantProductos(), prod.getCostoCompra(), prod.getPrecioVenta());
                } else {
                    if (tipoProducto.compareToIgnoreCase("Carnes") == 0) {
                        prod.leerDatos();
                        p[datosProductos.length + cont] = new Carnes(prod.getCodigo(), prod.getDescripcion(), prod.getCantProductos(), prod.getCostoCompra(), prod.getPrecioVenta());
                    } else {
                        if (tipoProducto.compareToIgnoreCase("Viveres") == 0) {
                            prod.leerDatos();
                            System.out.println("Ingrese la marca del producto: ");
                            marcaProducto = entrada.nextLine();
                            p[datosProductos.length + cont] = new Viveres(marcaProducto, prod.getCodigo(), prod.getDescripcion(), prod.getCantProductos(), prod.getCostoCompra(), prod.getPrecioVenta());
                        } else {
                            System.err.println("Este tipo de producto no se vende en este supermercado");
                            cont--;
                        }
                    }
                }
            }
            entrada.nextLine();
            for (int a = 0; a < datosProductos.length + cont; a++) {
                if (p[datosProductos.length + cont].getCodigo().compareToIgnoreCase(p[a].getCodigo()) == 0) {
                    System.out.println("Este codigo ya fue usado, por favor introduce otro codigo: ");
                    codigoNuevo = entrada.nextLine();
                    p[datosProductos.length + cont].setCodigo(codigoNuevo);
                    entrada.nextLine();
                    a = 0;
                }
            }
            System.out.println("Desea agregar otro producto al almacen? S/N");
            resp = entrada.next();
            cont++;
        } while (resp.compareToIgnoreCase("S") == 0);

        for (int x = 0; x < p.length; x++) {
            if (p[x] instanceof Enlatados) {
                System.out.println("codigo: " + p[x].getCodigo() + "\ndescripcion: " + p[x].getDescripcion() + "\nMarca: " + ((Enlatados) (p[x])).getMarca() + "\nCosto: " + p[x].getCostoCompra() + "\nPrecio: " + p[x].getPrecioVenta() + "\nCantidada de productos: " + p[x].getCantProductos());
            }
            if (p[x] instanceof Lacteos) {
                System.out.println("codigo: " + p[x].getCodigo() + "\ndescripcion: " + p[x].getDescripcion() + "\nCosto: " + p[x].getCostoCompra() + "\nPrecio: " + p[x].getPrecioVenta() + "\nCantidada de productos: " + p[x].getCantProductos());
            }
            if (p[x] instanceof Carnes) {
                System.out.println("codigo: " + p[x].getCodigo() + "\ndescripcion: " + p[x].getDescripcion() + "\nCosto: " + p[x].getCostoCompra() + "\nPrecio: " + p[x].getPrecioVenta() + "\nCantidada de productos: " + p[x].getCantProductos());
            }
            if (p[x] instanceof Viveres) {
                System.out.println("codigo: " + p[x].getCodigo() + "\ndescripcion: " + p[x].getDescripcion() + "\nMarca: " + ((Viveres) (p[x])).getMarca() + "\nCosto: " + p[x].getCostoCompra() + "\nPrecio: " + p[x].getPrecioVenta() + "\nCantidada de productos: " + p[x].getCantProductos());
            }
        }
        entrada.nextLine();
        tam = datosProductos.length + cont;
        System.out.println("tamaño de p: " + p.length);
        menu();
    }

    public void modificarProducto() {
        int cant;

        System.out.println("Ingrese el codigo del producto a modificar: ");
        entrada.nextLine();
        cod = entrada.nextLine();
        for (int i = 0; i < tam; i++) {
            if (cod.compareToIgnoreCase(p[i].getCodigo()) == 0) {
                System.out.println("¿Cuantos productos deseas agregarle?");
                cant = entrada.nextInt();
                if (p[i] instanceof Enlatados) {
                    int totProducts = cant + p[i].getCantProductos();
                    p[i].setCantProductos(totProducts);
                } else {
                    if (p[i] instanceof Lacteos) {
                        int totProducts = cant + p[i].getCantProductos();
                        p[i].setCantProductos(totProducts);
                    } else {
                        if (p[i] instanceof Carnes) {
                            int totProducts = cant + p[i].getCantProductos();
                            p[i].setCantProductos(totProducts);
                        } else {
                            if (p[i] instanceof Viveres) {
                                int totProducts = cant + p[i].getCantProductos();
                                p[i].setCantProductos(totProducts);
                            }
                        }
                    }
                }

            } else {
                if (i == (tam - 1) && cod.compareToIgnoreCase(p[i].getCodigo()) != 0) {
                    System.err.println("El codigo del producto ingresado no se encuentra en nuestro almacen");
                    entrada.nextLine();
                }
            }
        }
        menu();
    }

    public void facturarVenta() {
        String cedula, resp, resp2;
        double precExento = 0.0;
        double IVA = 0.0;
        double precioIVA = 0.0;
        double totalPagar = 0.0;
        int i = 0;
        int a;
        int auxProdVendidos = 0;

        do {
            a = 0;
            System.out.println("Cedula del cliente: ");
            entrada.nextLine();
            cedula = entrada.nextLine();
            do {
                System.out.println("¿Que producto deseas comprar?: ");
                productoVendido.add(a, entrada.nextLine());
                for (int x = 0; x < tam; x++) {
                    if (productoVendido.get(a).equals(p[x].getDescripcion())) {
                        System.out.println("¿Cuantos articulos deseas comprar?: ");
                        cantProdVendidos.add(a, entrada.nextInt());
                        do {
                            if (cantProdVendidos.get(a) > p[x].getCantProductos()) {
                                System.err.println("Disculpe, esa cantidad supera la cantidad total de existencia del producto. Por lo tanto, no podrá serle vendido. \nPor favor, ingrese otra cantidad a comprar: ");
                                cantProdVendidos.add(entrada.nextInt());
                            }
                        } while (cantProdVendidos.get(a) > p[x].getCantProductos());
                        double precTot = cantProdVendidos.get(a) * p[x].getPrecioVenta();
                        auxProdVendidos = p[x].getCantProductos() - cantProdVendidos.get(a);
                        p[x].setCantProductos(auxProdVendidos);
                        if ((p[x] instanceof Lacteos) || (p[x] instanceof Carnes)) {
                            precExento += precTot;
                        } else {
                            if ((p[x] instanceof Enlatados) || (p[x] instanceof Viveres)) {
                                IVA += (p[x].getPrecioVenta() * 0.12);
                                precioIVA += precTot + (p[x].getPrecioVenta() * 0.12);
                            }
                        }
                    } else {
                        //System.err.println("Este producto no esta a la venta");
                    }
                }
                totalPagar = precExento + precioIVA;

                System.out.println("¿Deseas comprar otro articulo?: S/N");
                entrada.nextLine();
                resp = entrada.nextLine();

                a++;

            } while (resp.compareToIgnoreCase("S") == 0);
            f.add(i, new Factura(cedula, productoVendido, cantProdVendidos, totalPagar));
            i++;
            System.out.println("¿Hay otro cliente?: S/N");
            resp2 = entrada.nextLine();
            entrada.nextLine();

        } while (resp2.compareToIgnoreCase("S") == 0);
        for (int y = 0; y < f.size(); y++) {
            System.out.println("------------------Factura # " + (y + 1) + "-------------------");
            System.out.println("------------------------------------------------");
            System.out.println("       codigo del articulo\tDescripcion del articulo\tCantidad por costo del articulo(Bs)\t total precio articulo(Bs)");
            for (int w = 0; w < productoVendido.size(); w++) {
                for (int z = 0; z < tam; z++) {
                    if (f.get(y).productoVender.get(w).compareToIgnoreCase(p[z].getDescripcion()) == 0) {
                        double precTot = cantProdVendidos.get(w) * p[z].getPrecioVenta();
                        System.out.println("\t\t" + p[z].getCodigo() + "\t\t" + productoVendido.get(w) + "\t\t\t\t" + cantProdVendidos.get(w) + " x " + p[z].getPrecioVenta() + "\t\t\t\t" + precTot);
                    }
                }
            }
            System.out.println("------------------------------------------------");
            System.out.println("Exento: " + precExento + " Bs.");
            System.out.println("IVA: " + IVA + " Bs.");
            System.out.println("Precio con IVA: " + precioIVA + " Bs.");
            System.out.println("-------------------------------------------------");
            System.out.println("Total a pagar: " + totalPagar + " Bs.");
        }

        menu();
    }

    public void ingresosBrutos() {
        double ingresos = 0.0;
        for (int i = 0; i < f.size(); i++) {
            if (i > 0) {
                f.get(i).precioTotal += f.get(i - 1).precioTotal;
            }
            ingresos = f.get(i).precioTotal;
        }
        System.out.println("El total recaudado de ventas fue de " + ingresos + " Bs.");
        menu();
    }

    public void egresosDeLaEmpresa() {
        double egresos = 0.0;

        for (int i = 0; i < tam; i++) {
            if (p[i] instanceof Enlatados) {
                egresos += p[i].getCostoCompra();
            }
            if (p[i] instanceof Lacteos) {
                egresos += p[i].getCostoCompra();
            }
            if (p[i] instanceof Carnes) {
                egresos += p[i].getCostoCompra();
            }
            if (p[i] instanceof Viveres) {
                egresos += p[i].getCostoCompra();
            }
        }
        System.out.println("El total evaluado de gastos fue de " + egresos + " Bs.");
        menu();
    }

    public void reporteExentosMayoresVentas() {
        int[] ordenMayor = new int[f.size()];
        int mayor = -1;
        String auxNombreProducto;
        p = new Producto[tam];
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < productoVendido.size(); j++) {
                for (int k = 0; k < p.length; k++) {
                    if (productoVendido.get(j).compareToIgnoreCase(p[k].getDescripcion()) == 0) {
                        if ((p[k] instanceof Lacteos) || (p[k] instanceof Carnes)) {
                            if (cantProdVendidos.get(j) > mayor) {
                                mayor = cantProdVendidos.get(j);
                                auxNombreProducto = f.get(i).getProductoVender();
                            }
                        }
                    }
                }
            }
        }
        menu();
    }

    public void reporteProductosExistenciaBaja() {
        p = new Producto[tam];
        System.out.println("Productos con existencia baja en el almacen");
        System.out.println("Codigo\tDescripcion\tCantidad de productos");
        for (int i = 0; i < p.length; i++) {
            if (p[i] instanceof Enlatados) {
                if (p[i].getCantProductos() < 10) {
                    System.out.println(p[i].getCodigo() + "\t" + p[i].getDescripcion() + "\t" + p[i].getCantProductos());
                }
            }
            if (p[i] instanceof Lacteos) {
                if (p[i].getCantProductos() < 10) {
                    System.out.println(p[i].getCodigo() + "\t" + p[i].getDescripcion() + "\t" + p[i].getCantProductos());
                }
            }
            if (p[i] instanceof Carnes) {
                if (p[i].getCantProductos() < 10) {
                    System.out.println(p[i].getCodigo() + "\t" + p[i].getDescripcion() + "\t" + p[i].getCantProductos());
                }
            }
            if (p[i] instanceof Viveres) {
                if (p[i].getCantProductos() < 10) {
                    System.out.println(p[i].getCodigo() + "\t" + p[i].getDescripcion() + "\t" + p[i].getCantProductos());
                }
            }
        }
        menu();
    }
}
