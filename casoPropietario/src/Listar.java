import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Listar extends JFrame {
    private ArrayList<Propietario> propietarios;
    private Inicio ventanaInicio;
    private JTextField txtBusqueda;
    private DefaultTableModel model;

    public Listar(ArrayList<Propietario> propietarios, Inicio ventanaInicio) {
        this.propietarios = propietarios;
        this.ventanaInicio = ventanaInicio;

        setTitle("Listar Propietarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel();
        JLabel lblBusqueda = new JLabel("Buscar:");
        panelBusqueda.add(lblBusqueda);
        txtBusqueda = new JTextField(20);
        panelBusqueda.add(txtBusqueda);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPropietario();
            }
        });
        panelBusqueda.add(btnBuscar);
        add(panelBusqueda, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        JButton btnAtras = new JButton("Volver a Inicio");
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInicio.volverAInicio();
                dispose();
            }
        });
        panelBotones.add(btnAtras);
        add(panelBotones, BorderLayout.SOUTH);

        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Documento");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Edad");

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        actualizarTabla(propietarios);

        setVisible(true);
    }

    private void buscarPropietario() {
        String textoBusqueda = txtBusqueda.getText().toLowerCase();
        ArrayList<Propietario> resultados = new ArrayList<>();
        for (Propietario propietario : propietarios) {
            if (propietario.getNombres().toLowerCase().contains(textoBusqueda) ||
                    propietario.getApellidos().toLowerCase().contains(textoBusqueda) ||
                    String.valueOf(propietario.getDocumento()).contains(textoBusqueda)) {
                resultados.add(propietario);
            }
        }
        actualizarTabla(resultados);
    }

    private void actualizarTabla(ArrayList<Propietario> listaPropietarios) {
        model.setRowCount(0);
        for (Propietario propietario : listaPropietarios) {
            model.addRow(new Object[]{
                    propietario.getId_Propietario(),
                    propietario.getDocumento(),
                    propietario.getNombres(),
                    propietario.getApellidos(),
                    propietario.getEdad()
            });
        }
    }
}
