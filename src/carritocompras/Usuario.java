/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Usuario {
    private String idUsuario;
    private String nombre;
    private String correo;
    private String contraseña;

    private static Map<String, Usuario> usuariosRegistrados = new HashMap<>();
    
    public Usuario(String idUsuario, String nombre, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public String getIdUsuario(){
        return idUsuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
       return correo;
    }
    public boolean validarContraseña(String contraseñaIngresada){ 
        return this.contraseña.equals(contraseñaIngresada);
    }
    
    public static boolean registrarUsuario(String idUsuario, String nombre, String correo, String contraseña) {
        if (!usuariosRegistrados.containsKey(idUsuario)) {
            Usuario nuevoUsuario = new Usuario(idUsuario, nombre, correo, contraseña);
            usuariosRegistrados.put(idUsuario, nuevoUsuario);
            System.out.println("Usuario registrado exitosamente.");
            return true;
        } else {
        System.out.println("Error: El ID de usuario ya está registrado.");
            return false;
        }
    }
    public static Usuario iniciarSesion(String idUsuario, String contraseñaIngresada) {
        Usuario usuario = usuariosRegistrados.get(idUsuario);
        if (usuario != null && usuario.validarContraseña(contraseñaIngresada)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
            return usuario;
        } else {
            System.out.println("Error: Credenciales incorrectas.");
            return null;
        }
    }
    public boolean cambiarContraseña(String contraseñaActual, String nuevaContraseña) {
        if (validarContraseña(contraseñaActual)) {
            this.contraseña = nuevaContraseña;
            System.out.println("Contraseña actualizada correctamente.");
            return true;
        } else {
            System.out.println("Error: La contraseña actual no es correcta.");
            return false;
        }
    }
    @Override
    public String toString(){
        return "ID Usuario: " + idUsuario + "- Nombre: " + nombre + "- Correo: " + correo;
    }
}
