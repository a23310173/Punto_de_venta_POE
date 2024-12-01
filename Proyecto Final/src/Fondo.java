import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Fondo extends JPanel {

    private BufferedImage imagen;

    public Fondo(String nombreImagen) {
        //Volver el tamaño del panel 720 x 480
        this.setSize(720, 480);

        try {
            // Construye la ruta completa de la imagen
            String rutaImagen = "iconos/" + nombreImagen;  // <-- Agrega el prefijo "icons/"
            URL imageUrl = getClass().getClassLoader().getResource(rutaImagen);
            if (imageUrl == null) {
                System.err.println("Imagen no encontrada: " + rutaImagen);
                return;
            }
            imagen = ImageIO.read(imageUrl);
        } catch (IOException ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}