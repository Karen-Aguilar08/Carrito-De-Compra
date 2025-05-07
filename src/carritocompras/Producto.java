/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

/**
 *
 * @author Admin
 */
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidadDisponible;
    private boolean envioGratis;

        public Producto(String id, String nombre, double precio, int cantidadDisponible, boolean envioGratis) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidadDisponible = cantidadDisponible;
            this.envioGratis = envioGratis;
        }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }
    public boolean tieneEnvioGratis(){
        return envioGratis;
    }
    public void reducirStock(int cantidadVendida){
        if(cantidadVendida <= cantidadDisponible){
            cantidadDisponible -= cantidadVendida;
        }else{
            System.out.println("Stock insuficiente para la venta.");
        }
    }
    @Override
public String toString() {
    return "ID: " + id + " - Nombre: " + nombre + " - Precio: $" + precio + " - Cantidad: " + cantidadDisponible;
}

    
}


