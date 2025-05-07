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
public class VentanaLogin extends JFrame{
    private CarritoCompras pantallaPrincipal;
    public VentanaLogin(CarritoCompras pantallaPrincipal){
        this.pantallaPrincipal=pantallaPrincipal;
        setTitle("Iniciar seción");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,2,5,5));
        
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        add(new JLabel("ID Usuario:"));
        JTextField idCampo = new JTextField(10);
        add(idCampo);

        add(new JLabel("Contraseña:"));
        JPasswordField contraseñaCampo = new JPasswordField(10);
        add(contraseñaCampo);

        JButton loginBtn = new JButton("Iniciar Sesión");
        loginBtn.setBackground(Color.YELLOW);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(loginBtn);
        
        JButton volverBtn = new JButton("Volver");
        volverBtn.setBackground(Color.YELLOW);
        volverBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(volverBtn);

        loginBtn.addActionListener(e -> {
            String id = idCampo.getText().trim();
            String contraseña = new String(contraseñaCampo.getPassword());
            
            Usuario usuario = Usuario.iniciarSesion(id, contraseña);
            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + usuario.getNombre() + "!");
                if(pantallaPrincipal !=null){
                pantallaPrincipal.mostrarCarritoCompras();
                dispose();
                } else {
                JOptionPane.showMessageDialog(this, "Error al cambiar de pantalla","Error",JOptionPane.ERROR_MESSAGE); 
                }
            }else{
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.", "Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        volverBtn.addActionListener(e -> dispose()); 
    }
}
