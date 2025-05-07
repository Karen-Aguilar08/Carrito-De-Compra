/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

import java.util.List;

public class Orden {
    private CarritoDeCompras carrito;

    public Orden(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    public boolean procesarPago(){
        double total = carrito.calcularTotal();
        return total > 0;
    }
    public void cancelarOrden() {
        carrito.vaciarCarrito();
    }
}