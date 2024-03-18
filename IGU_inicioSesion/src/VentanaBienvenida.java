import javax.swing.*;
import java.awt.*;

public class VentanaBienvenida extends JFrame {
    private JLabel labelBienvenida;

    public VentanaBienvenida(String nombreUsuario) {
        setTitle("Bienvenido");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200); // Establecer el tamaño de la ventana

        setLocationRelativeTo(null);

        labelBienvenida = new JLabel("Bienvenido, " + nombreUsuario + "!");
        labelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 220, 240));
        panel.add(labelBienvenida, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
    }
}
