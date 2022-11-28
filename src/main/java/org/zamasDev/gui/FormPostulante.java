package org.zamasDev.gui;

import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.mantenimiento.GestionPostulanteDAO;
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
import java.util.List;

public class FormPostulante extends JFrame {

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
    private JLabel lblDni;
    private JTextField txtDNI;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblEstado;

    private JLabel lblCiudad;
    private JComboBox cboEstado;
    private JComboBox cboCiudad;
    private JComboBox cboGenero;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JSeparator separator;
    private JSeparator separator_1;

    DefaultTableModel model = new DefaultTableModel();
    GestionPostulanteDAO postulanteDAO = new GestionPostulanteDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPostulante frame = new FormPostulante();
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
    public FormPostulante() {
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
        renderer.setBorder(null);
        renderer.setBackground(new Color(33, 79, 194));
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
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

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNombre.setBounds(10, 108, 79, 20);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(99, 109, 116, 22);
        panel.add(txtNombre);

        lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblApellido.setBounds(10, 139, 79, 20);
        panel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setColumns(10);
        txtApellido.setBounds(99, 140, 116, 22);
        panel.add(txtApellido);

        lblDni = new JLabel("DNI");
        lblDni.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblDni.setBounds(259, 108, 79, 20);
        panel.add(lblDni);

        txtDNI = new JTextField();
        txtDNI.setColumns(10);
        txtDNI.setBounds(348, 109, 116, 22);
        panel.add(txtDNI);

        lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTelefono.setBounds(259, 139, 79, 20);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(348, 140, 116, 22);
        panel.add(txtTelefono);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblEmail.setBounds(497, 108, 79, 20);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(497, 140, 220, 22);
        panel.add(txtEmail);

        lblEstado = new JLabel("Estado");
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblEstado.setBounds(259, 173, 79, 20);
        panel.add(lblEstado);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRegistrarActionPerformed(e);
            }
        });
        btnRegistrar.setBounds(430, 252, 89, 23);
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

        lblCiudad = new JLabel("Ciudad");
        lblCiudad.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblCiudad.setBounds(10, 170, 79, 20);
        panel.add(lblCiudad);

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("Telefono");
        model.addColumn("Email");
        model.addColumn("Estado");
        model.addColumn("Ciudad");
        model.addColumn("Genero");

        tbPostulantes.setModel(model);

        cboEstado = new JComboBox();
        cboEstado.setModel(new DefaultComboBoxModel(new String[]{"Pendiente ", "Aprobado", "Desaprobado"}));
        cboEstado.setBounds(348, 174, 116, 22);
        panel.add(cboEstado);

        cboCiudad = new JComboBox();
        cboCiudad.setModel(new DefaultComboBoxModel(new String[]{"Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco", "Ica", "Junín", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"}));
        cboCiudad.setBounds(99, 173, 116, 22);
        panel.add(cboCiudad);

        JLabel lblGenero = new JLabel("Genero");
        lblGenero.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblGenero.setBounds(497, 173, 79, 20);
        panel.add(lblGenero);

        cboGenero = new JComboBox();
        cboGenero.setModel(new DefaultComboBoxModel(new String[]{"Masculino", "Femenino"}));
        cboGenero.setSelectedIndex(0);
        cboGenero.setBounds(586, 174, 131, 22);
        panel.add(cboGenero);

        cargarDatos();
        limpiarCampos();
        setIncrementedCodigo();
    }

    //Methods

    protected void btnRegistrarActionPerformed(ActionEvent e) {

        String nombre, apellido, dni, telefono, email, estado, ciudad, genero;
        int id;

        nombre = getNombre();
        apellido = getApellido();
        dni = getDNI();
        telefono = getTelefono();
        email = getEmail();
        estado = getEstado();
        ciudad = getCiudad();
        genero = getGenero();

        if (nombre == null || apellido == null || dni == null || telefono == null || email == null || estado == null || ciudad == null || genero == null) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
            EntityPostulante postulante = new EntityPostulante();

            id = getId();

            postulante.setId(id);
            postulante.setNombre(nombre);
            postulante.setApellido(apellido);
            postulante.setDni(dni);
            postulante.setTelefono(telefono);
            postulante.setEmail(email);
            postulante.setEstado(estado);
            postulante.setCiudad(ciudad);
            postulante.setGenero(genero);

            int res = postulanteDAO.insertarPostulante(postulante);

            if (res == 0) {
                JOptionPane.showMessageDialog(null, "Error al registrar");
            } else {
                Object[] fila = {id, nombre, apellido, dni, telefono, email, estado, ciudad, genero};
                model.addRow(fila);
                JOptionPane.showMessageDialog(null, "Postulante registrado");
                limpiarCampos();
            }
        }
    }

    protected void btnActualizarActionPerformed(ActionEvent e) {
        int row = tbPostulantes.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            int id = Integer.parseInt(txtCodigo.getText());
            String nombre = getNombre();
            String apellido = getApellido();
            String dni = getDNI();
            String telefono = getTelefono();
            String email = getEmail();
            String estado = getEstado();
            String ciudad = getCiudad();
            String genero = getGenero();

            if (nombre == null || apellido == null || dni == null || telefono == null || email == null || estado == null || ciudad == null || genero == null) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            } else {
                EntityPostulante postulante = new EntityPostulante();

                postulante.setId(id);
                postulante.setNombre(nombre);
                postulante.setApellido(apellido);
                postulante.setDni(dni);
                postulante.setTelefono(telefono);
                postulante.setEmail(email);
                postulante.setEstado(estado);
                postulante.setCiudad(ciudad);
                postulante.setGenero(genero);

                int res = postulanteDAO.actualizarPostulante(postulante);

                if (res == 0) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                } else {
                    model.setValueAt(nombre, row, 1);
                    model.setValueAt(apellido, row, 2);
                    model.setValueAt(dni, row, 3);
                    model.setValueAt(telefono, row, 4);
                    model.setValueAt(email, row, 5);
                    model.setValueAt(estado, row, 6);
                    model.setValueAt(ciudad, row, 7);
                    model.setValueAt(genero, row, 8);
                    JOptionPane.showMessageDialog(null, "Postulante actualizado");
                    limpiarCampos();
                }
            }
        }
    }

    protected void btnEliminarActionPerformed(ActionEvent e) {
        int row = tbPostulantes.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            int id = Integer.parseInt(txtCodigo.getText());

            int res = postulanteDAO.eliminarPostulante(id);

            if (res == 0) {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } else {
                model.removeRow(row);
                JOptionPane.showMessageDialog(null, "Postulante eliminado");
                limpiarCampos();
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

    private String getGenero() {
        String genero = null;
        String getGenero = cboGenero.getSelectedItem().toString();

        if (getGenero.equals("Masculino")) {
            genero = "M";
        } else if (getGenero.equals("Femenino")) {
            genero = "F";
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el genero");
        }

        return genero;
    }

    private String getCiudad() {
        String ciudad = null;
        String getCiudad = cboCiudad.getSelectedItem().toString();

        if (getCiudad.equals("Amazonas")) {
            ciudad = "AM";
        } else if (getCiudad.equals("Ancash")) {
            ciudad = "AN";
        } else if (getCiudad.equals("Apurimac")) {
            ciudad = "AP";
        } else if (getCiudad.equals("Arequipa")) {
            ciudad = "AQ";
        } else if (getCiudad.equals("Ayacucho")) {
            ciudad = "AY";
        } else if (getCiudad.equals("Cajamarca")) {
            ciudad = "CA";
        } else if (getCiudad.equals("Callao")) {
            ciudad = "CL";
        } else if (getCiudad.equals("Cusco")) {
            ciudad = "CU";
        } else if (getCiudad.equals("Huancavelica")) {
            ciudad = "HV";
        } else if (getCiudad.equals("Huánuco")) {
            ciudad = "HO";
        } else if (getCiudad.equals("Ica")) {
            ciudad = "IC";
        } else if (getCiudad.equals("Junín")) {
            ciudad = "JU";
        } else if (getCiudad.equals("La Libertad")) {
            ciudad = "LL";
        } else if (getCiudad.equals("Lambayeque")) {
            ciudad = "LB";
        } else if (getCiudad.equals("Lima")) {
            ciudad = "LI";
        } else if (getCiudad.equals("Loreto")) {
            ciudad = "LO";
        } else if (getCiudad.equals("Madre de Dios")) {
            ciudad = "MD";
        } else if (getCiudad.equals("Moquegua")) {
            ciudad = "MO";
        } else if (getCiudad.equals("Pasco")) {
            ciudad = "PA";
        } else if (getCiudad.equals("Piura")) {
            ciudad = "PI";
        } else if (getCiudad.equals("Puno")) {
            ciudad = "PU";
        } else if (getCiudad.equals("San Martín")) {
            ciudad = "SM";
        } else if (getCiudad.equals("Tacna")) {
            ciudad = "TA";
        } else if (getCiudad.equals("Tumbes")) {
            ciudad = "TU";
        } else if (getCiudad.equals("Ucayali")) {
            ciudad = "UC";
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener la ciudad");
        }

        return ciudad;
    }

    private String getEstado() {
        String estado = null;
        int getEstado = cboEstado.getSelectedIndex();

        if (getEstado == 0) {
            estado = "Pendiente";
        } else if (getEstado == 1) {
            estado = "Aprobado";
        } else if (getEstado == 2) {
            estado = "Rechazado";
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado");
        }

        return estado;
    }

    private String getEmail() {
        String email = null;
        String getEmail = txtEmail.getText();

        if (getEmail.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo email no puede estar vacio");
        } else if (txtEmail.getText().trim().matches(RegexG.EMAIL)) {
            email = getEmail;
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el email");
        }

        return email;
    }

    private String getTelefono() {
        String telefono = null;
        String getTelefono = txtTelefono.getText();

        if (getTelefono.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo telefono no puede estar vacio");
        } else if (txtTelefono.getText().trim().matches(RegexG.TELEFONO)) {
            telefono = getTelefono;
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el telefono");
        }

        return telefono;
    }

    private String getDNI() {
        String dni = null;
        String getDNI = txtDNI.getText();

        if (getDNI.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo DNI no puede estar vacio");
        } else if (txtDNI.getText().trim().matches(RegexG.DNI)) {
            dni = getDNI;
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el DNI");
        }

        return dni;
    }

    private String getApellido() {
        String apellido = null;
        String getApellido = txtApellido.getText();

        if (getApellido.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo apellido no puede estar vacio");
        } else if (txtApellido.getText().trim().matches(RegexG.APELLIDO)) {
            apellido = getApellido;
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el apellido");
        }

        return apellido;
    }

    private String getNombre() {
        String nombre = null;
        String getNombre = txtNombre.getText();

        if (getNombre.length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
        } else if (txtNombre.getText().trim().matches(RegexG.NOMBRE)) {
            nombre = getNombre;
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el nombre");
        }

        return nombre;
    }

    public void cargarDatos() {
        List<EntityPostulante> postulantes = postulanteDAO.listarPostulante();

        for (EntityPostulante postulante : postulantes) {
            String[] datos = new String[9];
            datos[0] = String.valueOf(postulante.getId());
            datos[1] = postulante.getNombre();
            datos[2] = postulante.getApellido();
            datos[3] = postulante.getDni();
            datos[4] = postulante.getTelefono();
            datos[5] = postulante.getEmail();
            datos[6] = postulante.getEstado();
            datos[7] = postulante.getCiudad();
            datos[8] = postulante.getGenero();

            model.addRow(datos);
        }
    }

    private void mouseClickedTable(MouseEvent e) {
        int fila = tbPostulantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            String codigo = (String) tbPostulantes.getValueAt(fila, 0).toString();
            String nombre = (String) tbPostulantes.getValueAt(fila, 1);
            String apellido = (String) tbPostulantes.getValueAt(fila, 2);
            String dni = (String) tbPostulantes.getValueAt(fila, 3);
            String telefono = (String) tbPostulantes.getValueAt(fila, 4);
            String email = (String) tbPostulantes.getValueAt(fila, 5);
            String estado = (String) tbPostulantes.getValueAt(fila, 6);
            String ciudad = (String) tbPostulantes.getValueAt(fila, 7);
            String genero = (String) tbPostulantes.getValueAt(fila, 8);

            txtCodigo.setText(codigo);
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtDNI.setText(dni);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            cboEstado.setSelectedItem(estado);
            cboCiudad.setSelectedItem(ciudad);
            cboGenero.setSelectedItem(genero);
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cboEstado.setSelectedIndex(0);
        cboCiudad.setSelectedIndex(0);
        cboGenero.setSelectedIndex(0);
    }

    public void setIncrementedCodigo() {
        int codigo = 0;

        List<EntityPostulante> postulantes = postulanteDAO.listarPostulante();

        for (EntityPostulante postulante : postulantes) {
            codigo = postulante.getId();
        }

        codigo++;

        txtCodigo.setText(String.valueOf(codigo));
    }

}


