package org.zamasDev.gui;

import org.zamasDev.entity.EntityEmpleador;
import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.mantenimiento.GestionEmpleadorDAO;
import org.zamasDev.validaciones.global.RegexG;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FormEmpleador extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable tbPostulantes;
    private JLabel lblTitle;
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JLabel lblDni;
    private JTextField txtDNI;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JSeparator separator;
    private JSeparator separator_1;

    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JLabel lblLocalidad;
    private JTextField txtLocalidad;
    private JLabel lblCategoria;
    private JTextField txtCategoria;
    DefaultTableModel model = new DefaultTableModel();
    GestionEmpleadorDAO gestionEmpleadorDAO = new GestionEmpleadorDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormEmpleador frame = new FormEmpleador();
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
    public FormEmpleador() {
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
        JTableHeader header = tbPostulantes.getTableHeader();
        final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setBackground(new Color(33, 79, 194));
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
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
        lblCodigo.setBounds(10, 77, 79, 20);
        panel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setEnabled(false);
        txtCodigo.setBounds(99, 78, 79, 22);
        panel.add(txtCodigo);
        txtCodigo.setColumns(10);

        lblDni = new JLabel("DNI");
        lblDni.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblDni.setBounds(10, 108, 79, 20);
        panel.add(lblDni);

        txtDNI = new JTextField();
        txtDNI.setColumns(10);
        txtDNI.setBounds(99, 109, 116, 22);
        panel.add(txtDNI);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(430, 252, 89, 23);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnRegistrar(e);
            }
        });
        panel.add(btnRegistrar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(529, 253, 89, 23);
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnActualizar(e);
            }
        });
        panel.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(628, 253, 89, 23);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnEliminar(e);
            }
        });
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

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("Telefono");
        model.addColumn("Localidad");
        model.addColumn("Categoria");

        tbPostulantes.setModel(model);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNombre.setBounds(268, 108, 79, 20);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(357, 109, 116, 22);
        panel.add(txtNombre);

        lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblApellido.setBounds(512, 108, 79, 20);
        panel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setColumns(10);
        txtApellido.setBounds(601, 109, 116, 22);
        panel.add(txtApellido);

        lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTelefono.setBounds(10, 139, 79, 20);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(99, 140, 116, 22);
        panel.add(txtTelefono);

        lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblLocalidad.setBounds(268, 139, 79, 20);
        panel.add(lblLocalidad);

        txtLocalidad = new JTextField();
        txtLocalidad.setColumns(10);
        txtLocalidad.setBounds(357, 140, 116, 22);
        panel.add(txtLocalidad);

        lblCategoria = new JLabel("Categoria");
        lblCategoria.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblCategoria.setBounds(10, 170, 79, 20);
        panel.add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setColumns(10);
        txtCategoria.setBounds(99, 171, 116, 22);
        panel.add(txtCategoria);

        setIncrementedCodigo();
        limpiarCampos();
        cargarDatos();
    }

    private void actionPerformedBtnRegistrar(ActionEvent e) {

        String nombre, apellido, dni, telefono, localidad, categoria;
        int id;

        nombre = getNombre();
        apellido = getApellido();
        dni = getDni();
        telefono = getTelefono();
        localidad = getLocalidad();
        categoria = getCategoria();

        if (nombre == null || apellido == null || dni == null || telefono == null || localidad == null || categoria == null) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else {
            EntityEmpleador empleador = new EntityEmpleador();

            id = getId();

            empleador.setId(id);
            empleador.setNombre(nombre);
            empleador.setApellido(apellido);
            empleador.setDni(dni);
            empleador.setTelefono(telefono);
            empleador.setLocalidad(localidad);
            empleador.setCategoria(categoria);

            int res = gestionEmpleadorDAO.insertarEmpleador(empleador);

            if (res == 1) {
                Object[] fila = new Object[7];
                fila[0] = id;
                fila[1] = nombre;
                fila[2] = apellido;
                fila[3] = dni;
                fila[4] = telefono;
                fila[5] = localidad;
                fila[6] = categoria;
                model.addRow(fila);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Se registro correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar");
            }
        }

    }

    private void actionPerformedBtnActualizar(ActionEvent e) {
        int fila = tbPostulantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(txtCodigo.getText());
            String nombre = getNombre();
            String apellido = getApellido();
            String dni = getDni();
            String telefono = getTelefono();
            String localidad = getLocalidad();
            String categoria = getCategoria();

            if (nombre == null || apellido == null || dni == null || telefono == null || localidad == null || categoria == null) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            } else {
                EntityEmpleador empleador = new EntityEmpleador();
                empleador.setId(id);
                empleador.setNombre(nombre);
                empleador.setApellido(apellido);
                empleador.setDni(dni);
                empleador.setTelefono(telefono);
                empleador.setLocalidad(localidad);
                empleador.setCategoria(categoria);

                int res = gestionEmpleadorDAO.actualizarEmpleador(empleador);

                if (res == 1) {
                    model.setValueAt(nombre, fila, 1);
                    model.setValueAt(apellido, fila, 2);
                    model.setValueAt(dni, fila, 3);
                    model.setValueAt(telefono, fila, 4);
                    model.setValueAt(localidad, fila, 5);
                    model.setValueAt(categoria, fila, 6);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar");
                }
            }
        }
    }

    private void actionPerformedBtnEliminar(ActionEvent e) {
        int fila = tbPostulantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt((String) tbPostulantes.getValueAt(fila, 0).toString());
            int res = gestionEmpleadorDAO.eliminarEmpleador(id);
            if (res == 1) {
                model.removeRow(fila);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
        }
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

    private String getLocalidad() {
        String localidad = null;
        String getLocalidad = txtLocalidad.getText();

        if (getLocalidad.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Localidad");
        } else {
            localidad = getLocalidad;
        }

        return localidad;
    }

    private String getCategoria() {
        String categoria = null;
        String getCategoria = txtCategoria.getText();

        if (getCategoria.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una categoria");
        } else {
            categoria = getCategoria;
        }

        return categoria;
    }

    private String getTelefono() {
        String telefono = null;
        String getTelefono = txtTelefono.getText();

        if (getTelefono.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo telefono no puede estar vacio");
        } else if (getTelefono.trim().matches(RegexG.TELEFONO)) {
            telefono = getTelefono;
        } else {
            JOptionPane.showMessageDialog(null, "El campo telefono no es valido");
        }

        return telefono;
    }

    private String getDni() {
        String dni = null;
        String getDni = txtDNI.getText();

        if (getDni.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo DNI no puede estar vacio");
        } else if (getDni.trim().matches(RegexG.DNI)) {
            dni = getDni;
        } else {
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es valido");
        }

        return dni;
    }

    private String getApellido() {
        String apellido = null;
        String getApellido = txtApellido.getText();

        if (getApellido.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo apellido no puede estar vacio");
        } else if (getApellido.trim().matches(RegexG.APELLIDO)) {
            apellido = getApellido;
        } else {
            JOptionPane.showMessageDialog(null, "El campo apellido no es valido");
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

    private void mouseClickedTable(MouseEvent e) {
        int fila = tbPostulantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(String.valueOf(model.getValueAt(fila, 0)));
            String nombre = String.valueOf(model.getValueAt(fila, 1));
            String apellido = String.valueOf(model.getValueAt(fila, 2));
            String dni = String.valueOf(model.getValueAt(fila, 3));
            String telefono = String.valueOf(model.getValueAt(fila, 4));
            String localidad = String.valueOf(model.getValueAt(fila, 5));
            String categoria = String.valueOf(model.getValueAt(fila, 6));

            txtCodigo.setText(String.valueOf(id));
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtDNI.setText(dni);
            txtTelefono.setText(telefono);
            txtLocalidad.setText(localidad);
            txtCategoria.setText(categoria);
        }
    }

    private void cargarDatos() {
        List<EntityEmpleador> empleadores = gestionEmpleadorDAO.listarEmpleador();

        for (EntityEmpleador empleador : empleadores) {
            Object[] fila = new Object[7];
            fila[0] = empleador.getId();
            fila[1] = empleador.getNombre();
            fila[2] = empleador.getApellido();
            fila[3] = empleador.getDni();
            fila[4] = empleador.getTelefono();
            fila[5] = empleador.getLocalidad();
            fila[6] = empleador.getCategoria();
            model.addRow(fila);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtLocalidad.setText("");
        txtCategoria.setText("");
    }

    public void setIncrementedCodigo() {
        int codigo = 0;

        List<EntityEmpleador> empleadores = gestionEmpleadorDAO.listarEmpleador();

        for (EntityEmpleador empleador : empleadores) {
            codigo = empleador.getId();
        }

        codigo++;

        txtCodigo.setText(String.valueOf(codigo));
    }
}