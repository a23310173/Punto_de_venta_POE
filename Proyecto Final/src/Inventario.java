import javax.swing.*;

public class Inventario {
    private JTable Tabla;
    private JPanel Inventario;
    private JButton VOLVERButton;

    public Inventario() {
        JFrame frame = new JFrame("Registro_Producto");
        frame.setContentPane(Inventario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fondo fondo = new Fondo("fondo_marino.jpeg");
        fondo.setLayout(new OverlayLayout(fondo));
        Inventario.setOpaque(false);
        fondo.add(Inventario);
        frame.setContentPane(fondo);
        frame.pack();
        frame.setVisible(true);

        //Se crea la tabla
        String[] columnas = {"SKU", "Nombre", "Marca", "Precio", "Cantidad"};
        //Hacer la tabla transparente
        Tabla.setOpaque(false);
        ((JComponent)Tabla.getDefaultRenderer(Object.class)).setOpaque(false);

        //Mostar la tabla
        frame.add(new JScrollPane(Tabla));

        //Boton para volver a la ventana de inicio
        VOLVERButton.addActionListener(e -> {
            frame.dispose();
            Login ingreso = new Login();
        });


    }

}
