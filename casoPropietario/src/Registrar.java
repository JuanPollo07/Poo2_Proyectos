import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Registrar extends JFrame {
    private ArrayList<Propietario> propietarios;
    private Inicio ventanaInicio;

    private JLabel lblDocumento;
    private JTextField txtDocumento;
    private JLabel lblNombres;
    private JTextField txtNombres;
    private JLabel lblApellidos;
    private JTextField txtApellidos;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JButton btnRegistrar;
    private JButton btnAtras;

    public Registrar(ArrayList<Propietario> propietarios, Inicio ventanaInicio) {
        this.propietarios = propietarios;
        this.ventanaInicio = ventanaInicio;

        setTitle("Registrar Propietario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        lblDocumento = new JLabel("Documento:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblDocumento, gbc);
        txtDocumento = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtDocumento, gbc);

        lblNombres = new JLabel("Nombres:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNombres, gbc);
        txtNombres = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtNombres, gbc);

        lblApellidos = new JLabel("Apellidos:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblApellidos, gbc);
        txtApellidos = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtApellidos, gbc);

        lblEdad = new JLabel("Edad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblEdad, gbc);
        txtEdad = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtEdad, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPropietario();
            }
        });
        buttonPanel.add(btnRegistrar);

        btnAtras = new JButton("Volver a Inicio");
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInicio.volverAInicio();
                dispose();
            }
        });
        buttonPanel.add(btnAtras);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        add(buttonPanel, gbc);

        setVisible(true);

    }
    private void registrarPropietario() {
        try {
            int documento = Integer.parseInt(txtDocumento.getText());
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Propietario propietario = new Propietario(documento, nombres, apellidos, edad);
            propietarios.add(propietario);
            JOptionPane.showMessageDialog(this, "Propietario registrado exitosamente.");
            txtDocumento.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtEdad.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos para el documento y la edad.");
        }
    }
}