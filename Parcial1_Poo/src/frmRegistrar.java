import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmRegistrar extends JFrame {
    JButton btnGuardar, btnVolver;
    JTextField txtNombre, txtApellido, txtEdad, txtCurso;
    ArrayList<Estudiante> estudiantes;

    public frmRegistrar(ArrayList<Estudiante> estudiantes) {
        setTitle("Registrar Estudiantes");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        this.estudiantes = estudiantes;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Registrar Estudiantes");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Apellido:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Edad:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Curso:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtNombre = new JTextField(15);
        panel.add(txtNombre, gbc);
        gbc.gridy++;
        txtApellido = new JTextField(15);
        panel.add(txtApellido, gbc);
        gbc.gridy++;
        txtEdad = new JTextField(15);
        panel.add(txtEdad, gbc);
        gbc.gridy++;
        txtCurso = new JTextField(15);
        panel.add(txtCurso, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 0, 0, 0);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String curso = txtCurso.getText();
                Estudiante estudiante = new Estudiante(nombre, apellido, edad, curso);
                estudiantes.add(estudiante);
                JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        buttonPanel.add(btnGuardar);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(btnVolver);

        panel.add(buttonPanel, gbc);

        getContentPane().add(panel);
    }
}
