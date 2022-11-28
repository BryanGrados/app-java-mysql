package org.zamasDev.gui;

import com.toedter.calendar.JDateChooser;
import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.mantenimiento.GestionPracticanteDAO;
import org.zamasDev.validaciones.global.RegexG;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FormPracticante extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable tbPostulantes;
    private JLabel lblTitle;
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JSeparator separator;
    private JSeparator separator_1;
    private JLabel lblSueldo;
    private JTextField txtSueldo;
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JLabel lblFechaIngreso;
    private JLabel lblBuscarPorDNI;
    private JTextField txtBuscarPorDNI;
    private JButton btnBuscar;
    private JDateChooser txtFechaIngreso;
    DefaultTableModel model = new DefaultTableModel();

    GestionPracticanteDAO gestionPracticanteDAO = new GestionPracticanteDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPracticante frame = new FormPracticante();
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
    public FormPracticante() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 743, 543);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 727, 504);
        contentPane.add(panel);
        panel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        scrollPane.setEnabled(false);
        scrollPane.setBounds(10, 287, 707, 196);
        panel.add(scrollPane);

        tbPostulantes = new JTable();
        tbPostulantes.setFocusable(false);
        tbPostulantes.setIntercellSpacing(new Dimension(1, 1));
        tbPostulantes.setGridColor(Color.BLACK);
        tbPostulantes.setRowHeight(20);
        tbPostulantes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tbPostulantes.setBackground(new Color(50, 132, 239));
        tbPostulantes.setForeground(Color.BLACK);
        tbPostulantes.setSelectionBackground(new Color(99, 152, 236));
        tbPostulantes.setSelectionForeground(Color.WHITE);
        tbPostulantes.setRowSelectionAllowed(true);
        tbPostulantes.setShowVerticalLines(false);
        tbPostulantes.setShowHorizontalLines(false);
        tbPostulantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedTable(e);
            }
        });
        tbPostulantes.getTableHeader().setReorderingAllowed(false);
        tbPostulantes.getTableHeader().setResizingAllowed(false);
        tbPostulantes.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Codigo", "Nombre", "Apellido", "DNI", "Telefono", "Email", "Genero", "Estado", "Ciudad"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        JTableHeader header = tbPostulantes.getTableHeader();
        final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        renderer.setBorder(null);
        renderer.setBackground(new Color(33, 79, 194));
        renderer.setForeground(Color.WHITE);
        header.setDefaultRenderer(renderer);
        scrollPane.setViewportView(tbPostulantes);
        tbPostulantes.setRowHeight(25);


        lblTitle = new JLabel("Mantenimiento de Postulantes");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setBounds(10, 0, 707, 49);
        panel.add(lblTitle);

        lblCodigo = new JLabel("Código");
        lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblCodigo.setBounds(10, 77, 139, 20);
        panel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(159, 77, 79, 22);
        txtCodigo.setEditable(false);
        panel.add(txtCodigo);
        txtCodigo.setColumns(10);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNombre.setBounds(10, 108, 139, 20);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(159, 108, 116, 22);
        txtNombre.setEditable(false);
        panel.add(txtNombre);

        lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblApellido.setBounds(10, 139, 139, 20);
        panel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setColumns(10);
        txtApellido.setBounds(159, 139, 116, 22);
        txtApellido.setEditable(false);
        panel.add(txtApellido);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRegistrarActionPerformed(e);
            }
        });
        btnRegistrar.setBounds(430, 253, 89, 23);
        panel.add(btnRegistrar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnActualizarActionPerformed(e);
            }
        });
        btnActualizar.setBounds(529, 253, 89, 23);
        panel.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnEliminarActionPerformed(e);
            }
        });
        btnEliminar.setBounds(628, 253, 89, 23);
        panel.add(btnEliminar);

        separator = new JSeparator();
        separator.setBounds(10, 239, 707, 2);
        panel.add(separator);

        separator_1 = new JSeparator();
        separator_1.setBounds(10, 47, 707, 2);
        panel.add(separator_1);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 287, 707, 196);
        panel.add(scrollPane);

        lblFechaIngreso = new JLabel("Fecha Ingreso");
        lblFechaIngreso.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblFechaIngreso.setBounds(327, 108, 116, 20);
        panel.add(lblFechaIngreso);

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha Ingreso");
        model.addColumn("Sueldo");
        model.addColumn("DNI");

        tbPostulantes.setModel(model);

        lblSueldo = new JLabel("Sueldo");
        lblSueldo.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblSueldo.setBounds(327, 139, 116, 20);
        panel.add(lblSueldo);

        txtSueldo = new JTextField();
        txtSueldo.setColumns(10);
        txtSueldo.setBounds(453, 140, 139, 22);
        panel.add(txtSueldo);

        lblDNI = new JLabel("DNI");
        lblDNI.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblDNI.setBounds(10, 170, 139, 20);
        panel.add(lblDNI);

        txtDNI = new JTextField();
        txtDNI.setColumns(10);
        txtDNI.setEditable(false);
        txtDNI.setBounds(159, 170, 79, 22);
        panel.add(txtDNI);

        txtFechaIngreso = new JDateChooser();
        txtFechaIngreso.setBounds(453, 108, 139, 20);
        panel.add(txtFechaIngreso);

        lblBuscarPorDNI = new JLabel("Buscar practicante por DNI:");
        lblBuscarPorDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblBuscarPorDNI.setBounds(10, 252, 200, 24);
        panel.add(lblBuscarPorDNI);

        txtBuscarPorDNI = new JTextField();
        txtBuscarPorDNI.setBounds(200, 256, 116, 20);
        panel.add(txtBuscarPorDNI);
        txtBuscarPorDNI.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnBuscar(e);
            }
        });
        btnBuscar.setBounds(330, 253, 89, 23);
        panel.add(btnBuscar);

        cargarDatos();
        limpiarCampos();
        setIncrementedCodigo();
        timer();
    }

    //Methods

    protected void btnRegistrarActionPerformed(ActionEvent e) {

        String nombre, apellido, fechaIngreso, dni;
        int id;
        double sueldo;

        nombre = getNombre();
        apellido = getApellido();
        fechaIngreso = getFechaIngreso();
        sueldo = getSueldo();
        dni = getDni();

        if (nombre == null || apellido == null || fechaIngreso == null || sueldo == 0 || dni == null) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else {
            EntityPracticante practicante = new EntityPracticante();

            id = getId();

            practicante.setId(id);
            practicante.setNombre(nombre);
            practicante.setApellido(apellido);
            practicante.setFechaIngreso(fechaIngreso);
            practicante.setSueldo(sueldo);
            practicante.setDni(dni);

            int res = gestionPracticanteDAO.insertarPracticante(practicante);

            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Practicante registrado con exito");
                Object[] fila = new Object[6];
                fila[0] = id;
                fila[1] = nombre;
                fila[2] = apellido;
                fila[3] = fechaIngreso;
                fila[4] = sueldo;
                fila[5] = dni;
                model.addRow(fila);
                limpiarCampos();
                setIncrementedCodigo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar practicante");
            }
        }
    }

    protected void btnActualizarActionPerformed(ActionEvent e) {
        int row = tbPostulantes.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un practicante");
        } else {
            int id = (int) tbPostulantes.getValueAt(row, 0);
            String fechaIngreso = getFechaIngreso();
            double sueldo = getSueldo();

            if (fechaIngreso == null || sueldo == 0) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            } else {
                EntityPracticante practicante = new EntityPracticante();

                practicante.setId(id);
                practicante.setFechaIngreso(fechaIngreso);
                practicante.setSueldo(sueldo);

                int res = gestionPracticanteDAO.actualizarPracticante(practicante);

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Practicante actualizado con exito");
                    model.setValueAt(fechaIngreso, row, 3);
                    model.setValueAt(sueldo, row, 4);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar practicante");
                }
            }

        }
    }

    protected void btnEliminarActionPerformed(ActionEvent e) {

        int row = tbPostulantes.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un practicante");
        } else {
            int id = (int) tbPostulantes.getValueAt(row, 0);

            int res = gestionPracticanteDAO.eliminarPracticante(id);

            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Practicante eliminado con exito");
                model.removeRow(row);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar practicante");
            }
        }

    }

    protected void actionPerformedBtnBuscar(ActionEvent e) {
        String dni = getBuscarDNI();

        if (gestionPracticanteDAO.buscarPracticante(dni).getDni() == null) {
            JOptionPane.showMessageDialog(null, "El DNI ingresado no existe");
        } else {
            EntityPracticante practicante = gestionPracticanteDAO.buscarPracticante(dni);

            txtCodigo.setText(String.valueOf(practicante.getId()));
            txtNombre.setText(practicante.getNombre());
            txtApellido.setText(practicante.getApellido());
            txtDNI.setText(practicante.getDni());
        }
    }

    private String getDni() {
        String dni = null;
        String txtDni = txtDNI.getText();

        if (txtDni.length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un DNI");
        } else if (txtDni.trim().matches(RegexG.DNI)) {
            dni = txtDni;
        } else {
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es valido");
        }

        return dni;
    }

    private int getId() {
        int id = 0;

        if (tbPostulantes.getRowCount() == 0) {
            id = 1;
        } else {
            id = Integer.parseInt(String.valueOf(model.getValueAt(tbPostulantes.getRowCount() - 1, 0))) + 1;
        }

        return id;
    }


    public void cargarDatos() {
        List<EntityPracticante> practicantes = gestionPracticanteDAO.listarPracticante();

        for (EntityPracticante practicante : practicantes) {
            model.addRow(new Object[]{practicante.getId(), practicante.getNombre(), practicante.getApellido(), practicante.getFechaIngreso(), practicante.getSueldo(), practicante.getDni()});
        }

        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDNI.getText().isEmpty()) {
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnRegistrar.setEnabled(false);
        } else {
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnRegistrar.setEnabled(true);
        }
    }

    private void mouseClickedTable(MouseEvent e) {
        int fila = tbPostulantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(String.valueOf(model.getValueAt(fila, 0)));
            String nombre = String.valueOf(model.getValueAt(fila, 1));
            String apellido = String.valueOf(model.getValueAt(fila, 2));
            String fechaIngreso = String.valueOf(model.getValueAt(fila, 3));
            String sueldo = String.valueOf(model.getValueAt(fila, 4));
            String idPostulante = String.valueOf(model.getValueAt(fila, 5));

            txtCodigo.setText(String.valueOf(id));
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtFechaIngreso.setDate(Date.valueOf(fechaIngreso));
            txtSueldo.setText(sueldo);
            txtDNI.setText(idPostulante);
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtSueldo.setText("");
        txtDNI.setText("");
        txtFechaIngreso.setDate(new Date(new java.util.Date().getTime()));
    }

    public void setIncrementedCodigo() {
        int codigo = 0;

        List<EntityPracticante> practicantes = gestionPracticanteDAO.listarPracticante();

        for (EntityPracticante practicante : practicantes) {
            codigo = practicante.getId();
        }

        codigo++;

        txtCodigo.setText(String.valueOf(codigo));
    }

    private double getSueldo() {

        double sueldo = 0;
        String getSueldo = txtSueldo.getText();

        if (getSueldo.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un sueldo");
        } else if (getSueldo.trim().matches(RegexG.DINERO)) {
            sueldo = Double.parseDouble(getSueldo);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un sueldo valido");
        }

        return sueldo;
    }

    private String getFechaIngreso() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIngreso = sdf.format(txtFechaIngreso.getDate());

        return fechaIngreso;
    }

    private String getApellido() {

        String apellido = null;
        String getApellido = txtApellido.getText();

        if (getApellido.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un apellido");
        } else if (getApellido.trim().matches(RegexG.APELLIDO)) {
            apellido = getApellido;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un apellido valido");
        }

        return apellido;
    }

    private String getNombre() {

        String nombre = null;
        String getNombre = txtNombre.getText();

        if (getNombre.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
        } else if (getNombre.trim().matches(RegexG.NOMBRE)) {
            nombre = getNombre;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
        }

        return nombre;
    }

    private String getBuscarDNI() {

        String dni = null;
        String txtDNI = txtBuscarPorDNI.getText();

        if (txtDNI.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un dni");
        } else if (txtDNI.trim().matches(RegexG.DNI)) {
            dni = txtDNI;
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un dni valido");
        }

        return dni;
    }

    public void timer() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDNI.getText().isEmpty() || txtSueldo.getText().isEmpty()) {
                    btnActualizar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnRegistrar.setEnabled(false);
                } else {
                    btnActualizar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnRegistrar.setEnabled(true);
                }
            }
        });
        timer.start();
    }

}


