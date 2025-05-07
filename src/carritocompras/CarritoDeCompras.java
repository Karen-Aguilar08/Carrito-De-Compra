/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private ArrayList<Producto> productos;
    
    public CarritoDeCompras(){
        productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("✔ Producto agregado al carrito: " + producto.getNombre());
    }
    public boolean eliminarProducto(String id){
        return productos.removeIf(producto -> producto.getId().equals(id));
    }
    public double calcularTotal(){
        double total = 0;
        for(Producto producto:productos){
            total += producto.getPrecio() * producto.getCantidadDisponible();
        }
        return total;
    }
    public void vaciarCarrito(){
        productos.clear();
    }
    public ArrayList<Producto>getProductos(){
        return productos;
    }
}

  