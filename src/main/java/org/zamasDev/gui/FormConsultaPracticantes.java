package org.zamasDev.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.toedter.calendar.JDateChooser;
import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.mantenimiento.ConsultasPracticantesDAO;

public class FormConsultaPracticantes extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblTitulo;
    private JSeparator sp;
    private JLabel lblPorNombre;
    private JScrollPane scrollPane;
    private JTable tblConsultas;
    private JTextField txtNombre;
    private JButton btnLimpiar;
    private JLabel lblPorDNI;
    private JTextField txtDNI;
    private JLabel lblPorFecha;
    private JLabel lblPorSueldo;
    private JTextField txtTotal;
    private JLabel lblTotal;
    private JTextField txtSueldo1;
    private JLabel lblY;
    private JTextField txtSueldo2;
    private JDateChooser txtFecha;

    DefaultTableModel model = new DefaultTableModel();
    ConsultasPracticantesDAO consultas = new ConsultasPracticantesDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormConsultaPracticantes frame = new FormConsultaPracticantes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormConsultaPracticantes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 443);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 609, 404);
        contentPane.add(panel);
        panel.setLayout(null);

        lblTitulo = new JLabel("Consulta de Practicantes Registrados");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 0, 609, 67);
        panel.add(lblTitulo);

        sp = new JSeparator();
        sp.setBounds(10, 65, 589, 2);
        panel.add(sp);

        lblPorNombre = new JLabel("Buscar por Nombre");
        lblPorNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorNombre.setBounds(10, 78, 135, 24);
        panel.add(lblPorNombre);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 235, 589, 158);
        panel.add(scrollPane);

        tblConsultas = new JTable();
        scrollPane.setViewportView(tblConsultas);

        txtNombre = new JTextField();
        txtNombre.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtNombre(e);
            }
        });
        txtNombre.setBounds(155, 78, 151, 20);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnLimpiar(e);
            }
        });
        btnLimpiar.setBounds(510, 147, 89, 23);
        panel.add(btnLimpiar);

        lblPorDNI = new JLabel("Buscar por DNI");
        lblPorDNI.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorDNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorDNI.setBounds(10, 113, 135, 24);
        panel.add(lblPorDNI);

        txtDNI = new JTextField();
        txtDNI.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtDNI(e);
            }
        });
        txtDNI.setColumns(10);
        txtDNI.setBounds(155, 113, 151, 20);
        panel.add(txtDNI);

        lblPorFecha = new JLabel("Buscar por Fecha");
        lblPorFecha.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorFecha.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorFecha.setBounds(10, 148, 135, 24);
        panel.add(lblPorFecha);

        lblPorSueldo = new JLabel("Buscar por Sueldo");
        lblPorSueldo.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorSueldo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorSueldo.setBounds(10, 183, 135, 24);
        panel.add(lblPorSueldo);

        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setBounds(510, 187, 89, 20);
        panel.add(txtTotal);
        txtTotal.setColumns(10);

        lblTotal = new JLabel("Total de Practicantes");
        lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblTotal.setBounds(365, 190, 135, 14);
        panel.add(lblTotal);

        txtSueldo1 = new JTextField();
        txtSueldo1.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtSueldo1(e);
            }
        });
        txtSueldo1.setBounds(155, 187, 51, 20);
        panel.add(txtSueldo1);
        txtSueldo1.setColumns(10);

        lblY = new JLabel("<!>");
        lblY.setHorizontalAlignment(SwingConstants.CENTER);
        lblY.setBounds(216, 190, 29, 14);
        panel.add(lblY);

        txtSueldo2 = new JTextField();
        txtSueldo2.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtSueldo2(e);
            }
        });
        txtSueldo2.setColumns(10);
        txtSueldo2.setBounds(255, 187, 51, 20);
        panel.add(txtSueldo2);

        txtFecha = new JDateChooser();
        //evento when update date
        txtFecha.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                propertyChangeTxtFecha(evt);
            }
        });
        txtFecha.setBounds(155, 150, 151, 20);
        panel.add(txtFecha);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha de Ingreso");
        model.addColumn("Sueldo");
        model.addColumn("DNI");

        tblConsultas.setModel(model);
        txtFecha.setDate(new Date(new java.util.Date().getTime()));
        txtTotal.setText(String.valueOf(consultas.totalPracticantesEnMySQL()));
    }
    protected void actionPerformedBtnLimpiar(ActionEvent e) {
        txtNombre.setText("");
        txtDNI.setText("");
        txtSueldo1.setText("");
        txtSueldo2.setText("");
        txtFecha.setDate(new Date(new java.util.Date().getTime()));
        txtTotal.setText(String.valueOf(consultas.totalPracticantesEnMySQL()));
        model.setRowCount(0);
    }
    protected void caretUpdateTxtNombre(CaretEvent e) {
        String nombre = txtNombre.getText();
        if (nombre != null) {
            actualizarTablaNombre(nombre);
        }
    }

    private void actualizarTablaNombre(String nombre) {
        consultas.consultarPracticantePorNombre(nombre);
        model.setRowCount(0);
        for (EntityPracticante practicante : consultas.consultarPracticantePorNombre(nombre)) {
            model.addRow(new Object[] { practicante.getId(), practicante.getNombre(), practicante.getApellido(),
                    practicante.getFechaIngreso(), practicante.getSueldo(), practicante.getDni() });
        }
    }

    protected void caretUpdateTxtDNI(CaretEvent e) {
        String dni = txtDNI.getText();
        if (dni != null) {
            actualizarTablaDNI(dni);
        }
    }

    private void actualizarTablaDNI(String dni) {
        consultas.consultarPracticantePorDni(dni);
        model.setRowCount(0);
        for (EntityPracticante practicante : consultas.consultarPracticantePorDni(dni)) {
            model.addRow(new Object[] { practicante.getId(), practicante.getNombre(), practicante.getApellido(),
                    practicante.getFechaIngreso(), practicante.getSueldo(), practicante.getDni() });
        }
    }

    protected void propertyChangeTxtFecha(PropertyChangeEvent event) {
        String fecha = getFecha(txtFecha);
        if (fecha != null) {
            actualizarTablaFecha(fecha);
        }
    }

    private void actualizarTablaFecha(String fecha) {
        consultas.consultarPracticantePorFecha(String.valueOf(fecha));
        model.setRowCount(0);
        for (EntityPracticante practicante : consultas.consultarPracticantePorFecha(String.valueOf(fecha))) {
            model.addRow(new Object[] { practicante.getId(), practicante.getNombre(), practicante.getApellido(),
                    practicante.getFechaIngreso(), practicante.getSueldo(), practicante.getDni() });
        }
    }

    protected void caretUpdateTxtSueldo1(CaretEvent e) {
        String sueldo1 = txtSueldo1.getText();
        String sueldo2 = txtSueldo2.getText();
        if (sueldo1 != null && sueldo2 != null) {
            actualizarTablaSueldo(sueldo1, sueldo2);
        }
    }

    protected void caretUpdateTxtSueldo2(CaretEvent e) {
        String sueldo1 = txtSueldo1.getText();
        String sueldo2 = txtSueldo2.getText();
        if (sueldo1 != null && sueldo2 != null) {
            actualizarTablaSueldo(sueldo1, sueldo2);
        }
    }

    private void actualizarTablaSueldo(String sueldo1, String sueldo2) {
        consultas.consultarPracticantePorSueldo(sueldo1, sueldo2);
        model.setRowCount(0);
        for (EntityPracticante practicante : consultas.consultarPracticantePorSueldo(sueldo1, sueldo2)) {
            model.addRow(new Object[] { practicante.getId(), practicante.getNombre(), practicante.getApellido(),
                    practicante.getFechaIngreso(), practicante.getSueldo(), practicante.getDni() });
        }
    }

    private String getFecha(JDateChooser dateChooser) {
        String fecha = "";
        if (dateChooser.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.format(dateChooser.getDate());
        }
        return fecha;
    }

}
