import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frmListar extends JFrame {
    JButton btnVolver;
    JTable table;


    public frmListar(ArrayList<Estudiante> estudiantes) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Listar Estudiantes");
        setSize(400, 300);
        setLocationRelativeTo(null);


        String[] columnNames = {"Nombre", "Apellido", "Edad", "Curso"};
        Object[][] data = new Object[estudiantes.size()][4];
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            data[i][0] = estudiante.getNombre();
            data[i][1] = estudiante.getApellido();
            data[i][2] = estudiante.getEdad();
            data[i][3] = estudiante.getCurso();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(btnVolver, BorderLayout.CENTER);
        buttonPanel.setPreferredSize(new Dimension(scrollPane.getWidth(), btnVolver.getPreferredSize().height));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }
}
