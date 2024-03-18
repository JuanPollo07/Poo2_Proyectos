import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InterfazInicioSesion extends JFrame implements ActionListener {
    private JTextField campoUsuario;
    private JPasswordField campoContraseña;
    private JButton botonIniciarSesion;
    private VentanaBienvenida ventanaBienvenida;

    public InterfazInicioSesion() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Iniciar Sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtituloUsuario = new JLabel("Usuario:");
        JLabel subtituloContraseña = new JLabel("Contraseña:");
        campoUsuario = new JTextField(20);
        campoContraseña = new JPasswordField(20);
        botonIniciarSesion = new JButton("Iniciar Sesión");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(titulo, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(subtituloUsuario, gbc);
        gbc.gridx = 1;
        panel.add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(subtituloContraseña, gbc);
        gbc.gridx = 1;
        panel.add(campoContraseña, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(botonIniciarSesion, gbc);

        botonIniciarSesion.addActionListener(this);
        panel.setBackground(new Color(200, 220, 240));
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = campoUsuario.getText();
        String contraseña = new String(campoContraseña.getPassword());

        if (validarUsuario(usuario, contraseña)) {
            ventanaBienvenida = new VentanaBienvenida(usuario);
            ventanaBienvenida.setVisible(true);
            registrarIngreso(usuario);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }

    private boolean validarUsuario(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(contraseña)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void registrarIngreso(String usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ingresos.log", true))) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraFormateada = ahora.format(formateador);
            bw.write(fechaHoraFormateada + " - Usuario: " + usuario);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
