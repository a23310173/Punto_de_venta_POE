import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registro_Producto {
    private JTextField Marca_producto;
    private JTextField Nombre_producto;
    private JSpinner Precio_producto;
    private JSpinner Cantidad_producto;
    private JTextField SKU;
    private JButton GENERARSKUButton;
    private JButton REGISTRARButton;
    private JButton VOLVERButton;
    private JPanel Registro_Producto;

    public Registro_Producto() {
        JFrame frame = new JFrame("Registro_Producto");
        frame.setContentPane(Registro_Producto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fondo fondo = new Fondo("fondo_azul.jpeg");
        fondo.setLayout(new OverlayLayout(fondo));
        Registro_Producto.setOpaque(false);
        fondo.add(Registro_Producto);
        frame.setContentPane(fondo);
        frame.pack();
        frame.setVisible(true);

        //Solo se pueden ingresar letras y espacios en el campo de marca
        Marca_producto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        //Solo se pueden ingresar letras y numeros y espacios en el campo de nombre
        Nombre_producto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isDigit(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }
        });

        //Solo se pueden ingresar numeros en el campo de precio
        Precio_producto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        //Solo se pueden ingresar numeros en el campo de cantidad
        Cantidad_producto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        //Solo se pueden ingresar letras y numeros en el campo de SKU
        SKU.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        GENERARSKUButton.addActionListener(e -> {
            //Generar SKU
            SKU.setText("SKU" + (int) (Math.random() * 1000));
        });

        //Registrar solo si todos los campos estan llenos
        REGISTRARButton.addActionListener(e -> {
            String marca = Marca_producto.getText();
            String nombre = Nombre_producto.getText();
            int precio = (int) Precio_producto.getValue();
            int cantidad = (int) Cantidad_producto.getValue();
            String sku = SKU.getText();
            if (!marca.isEmpty() && !nombre.isEmpty() && !sku.isEmpty()) {
                //Registrar producto
                System.out.println("Producto registrado");
            }
        });

        /*
        VOLVERButton.addActionListener(e -> {
            Menu menu = new Menu();
            ((JFrame) Registro_Producto.getTopLevelAncestor()).dispose();
        });
        hhhhhhhhhhhhhh*/
    }
}
