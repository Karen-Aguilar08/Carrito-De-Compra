/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Cupon {
    private String codigo;
    private double descuento;
    private LocalDate fechaExpiracion;

    public Cupon(String codigo, double descuento, LocalDate fechaExpiracion) {
        if (descuento < 0 || descuento > 100) {
        throw new IllegalArgumentException("El descuento debe estar entre 0% y 100%");
    }
        this.codigo = codigo;
        this.descuento = descuento;
        this.fechaExpiracion = fechaExpiracion;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public double getDescuento(){
        return descuento;
    }
    public LocalDate getFechaExpiracion(){
        return fechaExpiracion;
    }
    public boolean esValido(){
        return LocalDate.now().isBefore(fechaExpiracion);
    }
    public double aplicarDescuento(double monto) {
    if (esValido()) {
        return monto - (monto * (descuento / 100));
    }
    return monto; 
}

    
    @Override
    public String toString(){
        return "Código: " + codigo + " - Descuento: " + descuento + "% - Expira: " + fechaExpiracion;
    }
}
