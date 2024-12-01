import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Login {
    private JPanel Ingreso;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel INFO;
    private JButton INGRESARButton;
    private JButton SALIRButton;
    private JLabel IMG1;
    private JLabel IMG2;
    private JPanel Login;

    public Login() {
        JFrame frame = new JFrame("Ingreso");
        frame.setContentPane(Ingreso);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //INGRESARButton.addActionListener(e -> verificarUsuario());
        SALIRButton.addActionListener(e -> System.exit(0));

        //Al dar enter en el campo de contraseña, verificar usuario
        //passwordField1.addActionListener(e -> verificarUsuario());

        //Al dar enter en el campo de usuario, pasar al campo de contraseña
        textField1.addActionListener(e -> passwordField1.requestFocus());


        // Si el mouse esta sobre algun boton, cambiar a la mano
        INGRESARButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SALIRButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Cambiar la label IMG1 e IMG2 por las imagenes "usuario.png" y "password.png" de la carpeta "iconos" que esta en src (src/iconos/) en tamaño 32x32
        try {
            IMG1.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/iconos/usuario.png"))).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
            IMG2.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/iconos/password.png"))).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
        } catch (NullPointerException e) {
            System.err.println("Iconos usuario.png o password.png no encontrados");
        }
        IMG1.setText("");
        IMG2.setText("");
    }

}