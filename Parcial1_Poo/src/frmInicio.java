import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class frmInicio extends JFrame {
    JButton btnRegistrar, btnListar;
    ArrayList<Estudiante> estudiantes;

    public frmInicio(String username) {
        setTitle("Inicio");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        estudiantes = new ArrayList<>();

        JLabel welcomeLabel = new JLabel("Bienvenido, " + username);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setAlignmentX(CENTER_ALIGNMENT);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmRegistrar registrar = new frmRegistrar(estudiantes);
                registrar.setVisible(true);
            }
        });
        buttonPanel.add(btnRegistrar);
        buttonPanel.add(Box.createHorizontalStrut(10));

        btnListar = new JButton("Listar Estudiantes");
        btnListar.setAlignmentX(CENTER_ALIGNMENT);
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmListar listar = new frmListar(estudiantes);
                listar.setVisible(true);
            }
        });
        buttonPanel.add(btnListar);

        buttonPanel.add(Box.createHorizontalGlue());
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }
}
