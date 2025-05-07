/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carritocompras;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class VentanaRegistro extends JFrame {
    public VentanaRegistro(){
        setTitle("Registro de Usuario");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5,2,5,5));
        
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        add(new JLabel("ID Usuario:"));
        JTextField idCampo=new JTextField(10);
        add(idCampo);
        
        add(new JLabel("Nombre:"));
        JTextField nombreCampo = new JTextField(10);
        add(nombreCampo);
        
        add(new JLabel("Correo:"));
        JTextField correoCampo=new JTextField(10);
        add(correoCampo);
        
        add(new JLabel("Contraseña:"));
        JPasswordField contraseñaCampo = new JPasswordField(10);
        add(contraseñaCampo);
        
        JButton registrarBtn = new JButton("Registrarse");
        registrarBtn.setBackground(Color.YELLOW);
        registrarBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(registrarBtn);
        
        JButton volverBtn = new JButton("Volver");
        volverBtn.setBackground(Color.YELLOW);
        volverBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(volverBtn);
        
        registrarBtn.addActionListener(e ->{
            String id = idCampo.getText().trim();
            String nombre = nombreCampo.getText().trim();
            String correo = correoCampo.getText().trim();
            String contraseña = new String(contraseñaCampo.getPassword());
            
            if (!id.isEmpty() && !nombre.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()) {
                Usuario.registrarUsuario(id, nombre, correo, contraseña);
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente!");
                dispose();
                new CarritoCompras().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        volverBtn.addActionListener(e -> {
            dispose();
            new CarritoCompras().setVisible(true);
        });
    }
}
