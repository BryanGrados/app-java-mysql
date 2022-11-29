package org.zamasDev.gui;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.mantenimiento.ConsultasPostulantesDAO;
import org.zamasDev.mantenimiento.GestionPostulanteDAO;
import org.zamasDev.mysql.MySQLConnector;
import org.zamasDev.validaciones.global.RegexG;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Highlighter;

public class FormConsultaPostulantes extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblTitulo;
    private JSeparator sp;
    private JLabel lblPorNombre;
    private JScrollPane scrollPane;
    private JTable tblConsultas;
    private JTextField txtNombre;
    private JButton btnLimpiar;
    private JButton btnGenerarReporte;
    private JLabel lblPorDNI;
    private JTextField txtDNI;
    private JLabel lblPorCiudad;
    private JComboBox cboCiudad;
    private JLabel lblPorEstado;
    private JComboBox cboEstado;
    private JTextField txtTotal;
    private JLabel lblTotal;

    DefaultTableModel model = new DefaultTableModel();
    ConsultasPostulantesDAO consultasPostulante = new ConsultasPostulantesDAO();
    GestionPostulanteDAO gestionPostulante = new GestionPostulanteDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormConsultaPostulantes frame = new FormConsultaPostulantes();
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
    public FormConsultaPostulantes() {
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

        lblTitulo = new JLabel("Consulta de Postulantes Registrados");
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
        txtNombre.setBounds(155, 78, 135, 20);
        txtNombre.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtNombre(e);
            }
        });
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        btnGenerarReporte = new JButton("Reporte");
        btnGenerarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedBtnGenerarReporte(e);
            }
        });
        btnGenerarReporte.setBounds(510, 78, 89, 23);
        panel.add(btnGenerarReporte);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformedbtnLimpiar(e);
            }
        });
        btnLimpiar.setBounds(510, 113, 89, 23);
        panel.add(btnLimpiar);

        lblPorDNI = new JLabel("Buscar por DNI");
        lblPorDNI.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorDNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorDNI.setBounds(10, 113, 135, 24);
        panel.add(lblPorDNI);

        txtDNI = new JTextField();
        txtDNI.setColumns(10);
        txtDNI.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                caretUpdateTxtDNI(e);
            }
        });
        txtDNI.setBounds(155, 113, 135, 20);
        panel.add(txtDNI);

        lblPorCiudad = new JLabel("Buscar por Ciudad");
        lblPorCiudad.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorCiudad.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorCiudad.setBounds(10, 148, 135, 24);
        panel.add(lblPorCiudad);

        lblPorEstado = new JLabel("Buscar por Estado");
        lblPorEstado.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorEstado.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPorEstado.setBounds(10, 183, 135, 24);
        panel.add(lblPorEstado);

        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setBounds(510, 187, 89, 20);
        panel.add(txtTotal);
        txtTotal.setColumns(10);

        lblTotal = new JLabel("Total de Postulantes");
        lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblTotal.setBounds(365, 190, 135, 14);
        panel.add(lblTotal);

        cboCiudad = new JComboBox();
        cboCiudad.setModel(new DefaultComboBoxModel(new String[]{"Seleccione", "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco", "Ica", "Junín", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"}));
        cboCiudad.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                itemStateChangedCboCiudad(e);
            }
        });
        cboCiudad.setBounds(155, 147, 135, 22);
        panel.add(cboCiudad);

        cboEstado = new JComboBox();
        cboEstado.addItem("Seleccione un estado");
        cboEstado.setModel(new DefaultComboBoxModel(new String[]{"Seleccione", "Pendiente ", "Aprobado", "Desaprobado"}));
        cboEstado.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                itemStateChangedCboEstado(e);
            }
        });
        cboEstado.setBounds(155, 186, 135, 22);
        panel.add(cboEstado);

        model.addColumn("ID");
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Ciudad");
        model.addColumn("Estado");
        model.addColumn("Telefono");

        tblConsultas.setModel(model);

        limpiarTabla();
        soloUnCampoActivo();
        cargarTabla();
        txtTotal.setText(String.valueOf(consultasPostulante.totalPostulantesEnMySQL()));
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void cargarTabla() {
        limpiarTabla();
        for (EntityPostulante postulante : gestionPostulante.listarPostulante()) {
            model.addRow(new Object[]{postulante.getId(), postulante.getDni(), postulante.getNombre(), postulante.getApellido(), postulante.getCiudad(), postulante.getEstado(), postulante.getTelefono()});
        }
    }

    private void actionPerformedBtnGenerarReporte(ActionEvent e) {
        imprimirPDF();
    }

    private void imprimirPDF() {
        String path = "src/main/java/org/zamasDev/pdf/ReportePostulantes.pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            Image image = Image.getInstance("src/main/java/org/zamasDev/pdf/logo.png");
            image.scaleAbsolute(100, 100);
            image.setAlignment(Element.ALIGN_CENTER);

            document.add(new Paragraph("Reporte de Postulantes", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            document.add(new Paragraph("Fecha: " + dtf.format(now), FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY)));
            document.add(image);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);

            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("ID"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("DNI"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Nombre"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Apellido"));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Ciudad"));
            PdfPCell cell6 = new PdfPCell(new Paragraph("Estado"));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Telefono"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);

            if (tblConsultas.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos para generar el reporte");
            } else {
                for (int i = 0; i < tblConsultas.getRowCount(); i++) {
                    String id = tblConsultas.getValueAt(i, 0).toString();
                    String dni = tblConsultas.getValueAt(i, 1).toString();
                    String nombre = tblConsultas.getValueAt(i, 2).toString();
                    String apellido = tblConsultas.getValueAt(i, 3).toString();
                    String ciudad = tblConsultas.getValueAt(i, 4).toString();
                    String estado = tblConsultas.getValueAt(i, 5).toString();
                    String telefono = tblConsultas.getValueAt(i, 6).toString();

                    table.addCell(id);
                    table.addCell(dni);
                    table.addCell(nombre);
                    table.addCell(apellido);
                    table.addCell(ciudad);
                    table.addCell(estado);
                    table.addCell(telefono);
                }
                document.add(table);
                document.close();
                Desktop.getDesktop().open(new File(path));
            }


        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void actionPerformedbtnLimpiar(ActionEvent e) {
        limpiarTabla();
        txtNombre.setText("");
        txtDNI.setText("");
        cboCiudad.setSelectedIndex(0);
        cboEstado.setSelectedIndex(0);
        txtTotal.setText(String.valueOf(consultasPostulante.totalPostulantesEnMySQL()));
    }

    private String getEstado() {
        String estado = null;
        int getEstado = cboEstado.getSelectedIndex();

        if (getEstado == 0) {
            estado = null;
        } else if (getEstado == 1) {
            estado = "Pendiente";
        } else if (getEstado == 2) {
            estado = "Aprobado";
        } else if (getEstado == 3) {
            estado = "Rechazado";
        }
        return estado;
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
        } else {
            ciudad = "UC";
        }
        return ciudad;
    }

    private String getDNI() {
        String dni = null;
        String getDNI = txtDNI.getText();

        dni = getDNI;

        return dni;
    }

    private String getNombre() {
        String nombre = null;
        String getNombre = txtNombre.getText();

        nombre = getNombre;

        return nombre;
    }

    protected void caretUpdateTxtNombre(CaretEvent e) {

        String nombre = getNombre();
        soloUnCampoActivo();
        if (nombre != null) {
            limpiarTabla();
            actualizarTablaPorNombre(nombre);
        }
    }

    private void caretUpdateTxtDNI(CaretEvent e) {

        String dni = getDNI();
        soloUnCampoActivo();
        if (dni != null) {
            limpiarTabla();
            actualizarTablaPorDNI(dni);
        }
    }

    private void itemStateChangedCboCiudad(ItemEvent e) {

        String ciudad = getCiudad();
        soloUnCampoActivo();
        if (ciudad != null) {
            limpiarTabla();
            actualizarTablaPorCiudad(ciudad);
        }

    }

    private void itemStateChangedCboEstado(ItemEvent e) {

        String estado = getEstado();
        soloUnCampoActivo();
        if (estado != null) {
            limpiarTabla();
            actualizarTablaPorEstado(estado);
        }

    }

    private void actualizarTablaPorEstado(String estado) {
        consultasPostulante.consultarPostulantePorEstado(estado);
        for (EntityPostulante postulante : consultasPostulante.consultarPostulantePorEstado(estado)) {
            model.addRow(new Object[]{postulante.getId(), postulante.getDni(), postulante.getNombre(), postulante.getApellido(), postulante.getCiudad(), postulante.getEstado(), postulante.getTelefono(), postulante.getTelefono()});
        }
    }

    private void actualizarTablaPorCiudad(String ciudad) {
        consultasPostulante.consultarPostulantePorCiudad(ciudad);
        for (int i = 0; i < consultasPostulante.consultarPostulantePorCiudad(ciudad).size(); i++) {
            model.addRow(new Object[]{consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getId(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getDni(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getNombre(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getApellido(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getCiudad(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getEstado(),
                    consultasPostulante.consultarPostulantePorCiudad(ciudad).get(i).getTelefono()});
        }
    }

    private void actualizarTablaPorNombre(String nombre) {
        consultasPostulante.consultarPostulantePorNombre(nombre);
        for (int i = 0; i < consultasPostulante.consultarPostulantePorNombre(nombre).size(); i++) {
            model.addRow(new Object[]{consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getId(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getDni(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getNombre(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getApellido(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getCiudad(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getEstado(),
                    consultasPostulante.consultarPostulantePorNombre(nombre).get(i).getTelefono()});
        }
    }

    private void actualizarTablaPorDNI(String dni) {
        consultasPostulante.consultarPostulantePorDni(dni);
        for (int i = 0; i < consultasPostulante.consultarPostulantePorDni(dni).size(); i++) {
            model.addRow(new Object[]{consultasPostulante.consultarPostulantePorDni(dni).get(i).getId(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getDni(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getNombre(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getApellido(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getCiudad(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getEstado(),
                    consultasPostulante.consultarPostulantePorDni(dni).get(i).getTelefono()});
        }
    }

    private void limpiarTabla() {
        for (int i = 0; i < tblConsultas.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    private void soloUnCampoActivo() {
        if (txtDNI.getText().length() > 0) {
            txtNombre.setEnabled(false);
            cboCiudad.setEnabled(false);
            cboEstado.setEnabled(false);
        } else if (txtNombre.getText().length() > 0) {
            txtDNI.setEnabled(false);
            cboCiudad.setEnabled(false);
            cboEstado.setEnabled(false);
        } else if (cboCiudad.getSelectedIndex() > 0) {
            txtDNI.setEnabled(false);
            txtNombre.setEnabled(false);
            cboEstado.setEnabled(false);
        } else if (cboEstado.getSelectedIndex() > 0) {
            txtDNI.setEnabled(false);
            txtNombre.setEnabled(false);
            cboCiudad.setEnabled(false);
        } else {
            txtDNI.setEnabled(true);
            txtNombre.setEnabled(true);
            cboCiudad.setEnabled(true);
            cboEstado.setEnabled(true);
        }
    }

    //timer para actualizar soloUnCampoActivo cada 1 segundo
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            soloUnCampoActivo();
        }
    });
}
