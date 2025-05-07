/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carritocompras;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class CarritoCompras extends JFrame{
    private JTextField idProductoCampo, nombreProductoCampo, precioProductoCampo, cantidadCampo, codigoCuponCampo;
    private JTextArea listaProductosArea, estadoOrdenArea;
    private CarritoDeCompras carrito = new CarritoDeCompras();
    private CardLayout cardLayout;
    private JPanel panelContenedor;
    
    public CarritoCompras(){
        setTitle("Tienda Online");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        carrito = new CarritoDeCompras();
        
        JPanel pantallaInicio = new JPanel(new BorderLayout());
        pantallaInicio.setBackground(Color.WHITE);
        
        JPanel franjaSuperior = new JPanel();
        franjaSuperior.setBackground(Color.YELLOW);
        franjaSuperior.setPreferredSize(new Dimension(600, 50));
        franjaSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel titulo = new JLabel("Carrito de Compras"); 
        titulo.setFont(new Font("Arial Black", Font.BOLD, 28));
        franjaSuperior.add(titulo);
        pantallaInicio.add(franjaSuperior, BorderLayout.NORTH);
        
        ImageIcon icono = new ImageIcon("C:\\Users\\Admin\\Pictures\\compras.jpg");
        Image imagen = icono.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        JLabel imagenLabel = new JLabel(icono, JLabel.CENTER);
        pantallaInicio.add(imagenLabel, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
         
        JButton registrarBtn = new JButton("Registrarse");
        registrarBtn.setPreferredSize(new Dimension(200,60));
        registrarBtn.setBackground(Color.YELLOW);
        registrarBtn.setFont(new Font("Arial", Font.BOLD, 18));
        JButton iniciarSesionBtn = new JButton("Iniciar Seción");
        iniciarSesionBtn.setPreferredSize(new Dimension(200,60));
        iniciarSesionBtn.setBackground(Color.YELLOW);
        iniciarSesionBtn.setFont(new Font("Arial", Font.BOLD, 18));
        
        panelBotones.add(registrarBtn);
        panelBotones.add(iniciarSesionBtn);
        pantallaInicio.add(panelBotones, BorderLayout.SOUTH);
        
        JPanel carritoPanel = new JPanel(new BorderLayout());
        carritoPanel.setBackground(Color.WHITE);
        
        JPanel panelSuperior = new JPanel(new GridLayout(2, 4));
        panelSuperior.setBackground(Color.WHITE);
        panelSuperior.add(new JLabel("ID Producto:"));
        idProductoCampo = new JTextField();
        panelSuperior.add(idProductoCampo);
        
        panelSuperior.add(new JLabel("Nombre Producto:"));
        nombreProductoCampo = new JTextField();
        panelSuperior.add(nombreProductoCampo);


        panelSuperior.add(new JLabel("Código Cupón:"));
        codigoCuponCampo = new JTextField();
        panelSuperior.add(codigoCuponCampo);

        panelSuperior.add(new JLabel("Cantidad:"));
        cantidadCampo = new JTextField();
        panelSuperior.add(cantidadCampo);

        panelSuperior.add(new JLabel("Precio:"));
        precioProductoCampo = new JTextField();
        panelSuperior.add(precioProductoCampo);
        
        carritoPanel.add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        listaProductosArea = new JTextArea();
        listaProductosArea.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelCentral.add(new JScrollPane(listaProductosArea));

        estadoOrdenArea = new JTextArea();
        estadoOrdenArea.setBorder(BorderFactory.createTitledBorder("Estado de Orden"));
        panelCentral.add(new JScrollPane(estadoOrdenArea));
        
        carritoPanel.add(panelCentral, BorderLayout.CENTER);
        
        JPanel panelInferior = new JPanel(new GridLayout(2, 3));
        JButton agregarProductoBtn = new JButton("Agregar Producto");
        agregarProductoBtn.setBackground(Color.YELLOW);
        panelInferior.add(agregarProductoBtn);

        JButton eliminarProductoBtn = new JButton("Eliminar Producto");
        eliminarProductoBtn.setBackground(Color.YELLOW);
        panelInferior.add(eliminarProductoBtn);
        
        JButton aplicarCuponBtn = new JButton("Aplicar Cupón");
        aplicarCuponBtn.setBackground(Color.YELLOW);
        panelInferior.add(aplicarCuponBtn);

        JButton calcularTotalBtn = new JButton("Calcular Total");
        calcularTotalBtn.setBackground(Color.YELLOW);
        panelInferior.add(calcularTotalBtn);

        JButton procesarPagoBtn = new JButton("Procesar Pago");
        procesarPagoBtn.setBackground(Color.YELLOW);
        panelInferior.add(procesarPagoBtn);

        JButton cancelarOrdenBtn = new JButton("Cancelar Orden");
        cancelarOrdenBtn.setBackground(Color.YELLOW);
        panelInferior.add(cancelarOrdenBtn);
        
        JButton volverBtn = new JButton("Volver");
        volverBtn.setBackground(Color.YELLOW);
        panelInferior.add(volverBtn);
        
        JButton salirBtn = new JButton("Salir");
        salirBtn.setBackground(Color.YELLOW);
        panelInferior.add(salirBtn);

        carritoPanel.add(panelInferior, BorderLayout.SOUTH);
        
        //Acciones de los botones
        agregarProductoBtn.addActionListener(e -> {
    try {
        String id = idProductoCampo.getText().trim();
        String nombre = nombreProductoCampo.getText().trim();
        double precio = Double.parseDouble(precioProductoCampo.getText());
        int cantidad = Integer.parseInt(cantidadCampo.getText());

        if (!id.isEmpty() && !nombre.isEmpty()) {
            Producto producto = new Producto(id, nombre, precio, cantidad, true); // ✅ Creación correcta
            carrito.agregarProducto(producto); 
            listaProductosArea.setText("");
            for (Producto p : carrito.getProductos()) {
                listaProductosArea.append(p.toString() + "\n");
            }
            
            idProductoCampo.setText("");
            nombreProductoCampo.setText("");
            precioProductoCampo.setText("");
            cantidadCampo.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese ID, nombre, precio y cantidad.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error: Ingrese valores numéricos válidos en precio y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

        eliminarProductoBtn.addActionListener(e -> {
            String id = idProductoCampo.getText();
            if (carrito.eliminarProducto(id)) {
                listaProductosArea.append("❌ Producto eliminado: " + id + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        aplicarCuponBtn.addActionListener(e -> {
        String codigo = codigoCuponCampo.getText();
        Cupon cupon = new Cupon(codigo, 10, LocalDate.of(2025, 12, 31)); 

    if (cupon.esValido()) {
        double totalConDescuento = cupon.aplicarDescuento(carrito.calcularTotal());
        estadoOrdenArea.append("✅ Cupón aplicado! Nuevo total: $" + totalConDescuento + "\n");
        codigoCuponCampo.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Cupón inválido o expirado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

        calcularTotalBtn.addActionListener(e -> {
            double total = carrito.calcularTotal();
            estadoOrdenArea.append("💲 Total de la compra: $" + total + "\n");
        });
        procesarPagoBtn.addActionListener(e -> {
            Orden orden = new Orden(carrito);
            boolean pagoExitoso = orden.procesarPago();

            if (pagoExitoso) {
                estadoOrdenArea.append("✅ Pago exitoso. ¡Gracias por tu compra!\n");
            } else {
                JOptionPane.showMessageDialog(this, "Error en el pago.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelarOrdenBtn.addActionListener(e -> {
            carrito.vaciarCarrito();
            listaProductosArea.setText("");
            estadoOrdenArea.setText("🚫 Orden cancelada.\n");
        });
        
        volverBtn.addActionListener(e -> cardLayout.show(panelContenedor, "inicio"));
        
        salirBtn.addActionListener(e -> System.exit(0));
        
        panelContenedor.add(pantallaInicio, "inicio");
        panelContenedor.add(carritoPanel, "carrito");
        
        add(panelContenedor, BorderLayout.CENTER);
        
        registrarBtn.addActionListener(e ->{
            new VentanaRegistro().setVisible(true);
        });
        
        iniciarSesionBtn.addActionListener(e ->{
            new VentanaLogin(this).setVisible(true);
        });
    }
    
    public void mostrarCarritoCompras(){
        cardLayout.show(panelContenedor, "carrito");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarritoCompras().setVisible(true));
    }
    
}
