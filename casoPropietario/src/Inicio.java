import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Inicio extends JFrame {
    private ArrayList<Propietario> propietarios;
    private Registrar ventanaRegistrar;
    private Listar ventanaListar;

    public Inicio(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;

        setTitle("Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnRegistrar = new JButton("Registrar Propietario");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaRegistrar == null) {
                    ventanaRegistrar = new Registrar(propietarios, Inicio.this); // Pasar la referencia de Inicio
                } else {
                    ventanaRegistrar.setVisible(true); // Mostrar la ventana existente
                }
                setVisible(false); // Ocultar la ventana actual
            }
        });
        add(btnRegistrar);

        JButton btnListar = new JButton("Listar Propietarios");
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventanaListar == null) {
                    ventanaListar = new Listar(propietarios, Inicio.this);
                } else {
                    ventanaListar.setVisible(true);
                }
                setVisible(false);
            }
        });
        add(btnListar);

        setVisible(true);
    }

    public static void main(String[] args) {
        ArrayList<Propietario> propietarios = new ArrayList<>();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio(propietarios);
            }
        });
    }

    public void volverAInicio() {
        setVisible(true);
    }
}