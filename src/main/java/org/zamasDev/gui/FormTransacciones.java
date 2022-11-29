package org.zamasDev.gui;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.mantenimiento.GestionPostulanteDAO;
import org.zamasDev.mantenimiento.TransaccionDAO;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormTransacciones extends JFrame {

    private JPanel contentPane;
    private JLabel lblTitulo;
    private JPanel panel;
    private JLabel lblBuscar;
    private JLabel lblCodigo;
    private JLabel lblNombres;
    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JPanel panel_1;
    private JPanel panel_2;
    private JTable tbTransacciones;
    private JScrollPane scrollPane;
    private JLabel lblImagen;
    private JLabel lblBG;
    private JTextField txtCodigoTran;
    private JTextField txtFecha;
    private JLabel lblCodigoTran;
    private JLabel lblFecha;
    private JLabel lblNewLabel_11;
    private JButton btnReporte;
    private JLabel lblEstado;
    private JTextField txtEstado;
    private JRadioButton btnAprobar;
    private JRadioButton rdbtnRechazar;
    private JLabel lblTotal;
    private JTextField txtTotal;

    DefaultTableModel model = new DefaultTableModel();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormTransacciones frame = new FormTransacciones();
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
    public FormTransacciones() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 619, 512);
        contentPane = new JPanel();
        contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        contentPane.setMaximumSize(new Dimension(33555, 33555));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("Transacción Postulantes");
        lblTitulo.setBounds(198, 0, 269, 42);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(lblTitulo);

        panel = new JPanel();
        panel.setBounds(10, 42, 348, 95);
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Postulantes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        lblBuscar = new JLabel("");
        lblBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedLblBuscar(e);
            }
        });
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/ImgSearch.png"));
        //set cursor pointer
        lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBuscar.setBounds(155, 25, 32, 20);
        panel.add(lblBuscar);

        lblCodigo = new JLabel("Código :");
        lblCodigo.setFont(new Font("Artifakt Element", Font.ITALIC, 12));
        lblCodigo.setBounds(10, 28, 65, 14);
        panel.add(lblCodigo);

        lblNombres = new JLabel("Nombres Completos :");
        lblNombres.setFont(new Font("Artifakt Element", Font.ITALIC, 12));
        lblNombres.setBounds(10, 53, 122, 14);
        panel.add(lblNombres);

        txtCodigo = new JTextField();
        txtCodigo.setEditable(false);
        txtCodigo.setColumns(10);
        txtCodigo.setBounds(68, 25, 77, 20);
        panel.add(txtCodigo);

        txtNombres = new JTextField();
        txtNombres.setEnabled(false);
        txtNombres.setColumns(10);
        txtNombres.setBounds(142, 50, 180, 20);
        panel.add(txtNombres);

        panel_1 = new JPanel();
        panel_1.setBounds(368, 42, 223, 95);
        panel_1.setBackground(Color.WHITE);
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Transacci\u00F3n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panel_1);

        txtCodigoTran = new JTextField();
        txtCodigoTran.setBounds(75, 29, 86, 20);
        txtCodigoTran.setEditable(false);
        panel_1.add(txtCodigoTran);
        txtCodigoTran.setColumns(10);

        txtFecha = new JTextField();
        txtFecha.setColumns(10);
        txtFecha.setEditable(false);
        txtFecha.setBounds(75, 60, 86, 20);
        panel_1.add(txtFecha);

        lblCodigoTran = new JLabel("Código :");
        lblCodigoTran.setFont(new Font("Artifakt Element", Font.ITALIC, 12));
        lblCodigoTran.setBounds(10, 32, 65, 14);
        panel_1.add(lblCodigoTran);

        lblFecha = new JLabel("Fecha :");
        lblFecha.setFont(new Font("Artifakt Element", Font.ITALIC, 12));
        lblFecha.setBounds(10, 63, 65, 14);
        panel_1.add(lblFecha);

        panel_2 = new JPanel();
        panel_2.setBounds(10, 150, 348, 157);
        panel_2.setBackground(Color.WHITE);
        panel_2.setLayout(null);
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cantidad de ingresantes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
        contentPane.add(panel_2);

        lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setBounds(199, 29, 43, 31);
        panel_2.add(lblNewLabel_11);

        btnReporte = new JButton("Generar Reporte");
        btnReporte.setBounds(10, 123, 328, 23);
        //add click event
        btnReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    btnReporteActionPerformed(e);
                } catch (DocumentException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel_2.add(btnReporte);

        lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblEstado.setBounds(10, 29, 65, 14);
        panel_2.add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setEnabled(false);
        txtEstado.setColumns(10);
        txtEstado.setBounds(67, 27, 77, 20);
        panel_2.add(txtEstado);

        btnAprobar = new JRadioButton("Aprobar");
        btnAprobar.setBounds(261, 26, 77, 23);
        panel_2.add(btnAprobar);

        rdbtnRechazar = new JRadioButton("Rechazar");
        rdbtnRechazar.setBounds(261, 52, 77, 23);
        panel_2.add(rdbtnRechazar);

        lblTotal = new JLabel("Total");
        lblTotal.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblTotal.setBounds(10, 73, 65, 14);
        panel_2.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setEnabled(false);
        txtTotal.setColumns(10);
        txtTotal.setBounds(67, 71, 77, 20);
        panel_2.add(txtTotal);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 318, 579, 144);
        contentPane.add(scrollPane);

        tbTransacciones = new JTable();
        tbTransacciones.setBackground(SystemColor.inactiveCaptionBorder);
        tbTransacciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tbTransacciones.getSelectedRow();
                String codigo = tbTransacciones.getValueAt(fila, 0).toString();
                String nombres = tbTransacciones.getValueAt(fila, 1).toString();
                String apellidos = tbTransacciones.getValueAt(fila, 2).toString();
                txtCodigo.setText(codigo);
                txtNombres.setText(nombres + " " + apellidos);
            }
        });
        scrollPane.setViewportView(tbTransacciones);

        lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/ImgTransact.png"));
        lblImagen.setBounds(378, 78, 223, 351);
        contentPane.add(lblImagen);

        lblBG = new JLabel("");
        lblBG.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/ImgBackground.jpg"));
        lblBG.setBounds(0, 0, 601, 512);
        contentPane.add(lblBG);

        model.addColumn("Codigo");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("DNI");

        tbTransacciones.setModel(model);


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        generateTranCode();
        generarFecha();
        cargarDatos();
    }

    private void btnReporteActionPerformed(ActionEvent e) throws DocumentException {
        imprimirPDF();
    }

    protected void mousePressedLblBuscar(MouseEvent e) {
    }

    //generar codigo con formato de 4 digitos
    private void generateTranCode() {
        int code = 0;
        String newCode = "";
        TransaccionDAO tranDAO = new TransaccionDAO();
        try {
            code = Integer.parseInt(tranDAO.idTransaccion(newCode));
            if (code == 0) {
                newCode = "TR0001";
            } else {
                DecimalFormat format = new DecimalFormat("TR0000");
                newCode = format.format(code + 1);
            }
            txtCodigoTran.setText(newCode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el código de la transacción");
        }
    }

    private void generarFecha() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(format.format(date));
    }

    private void cargarDatos() {
        GestionPostulanteDAO postDAO = new GestionPostulanteDAO();

        try {
            ArrayList<EntityPostulante> lista = postDAO.listarPostulante();
            model.setRowCount(0);
            for (EntityPostulante p : lista) {
                Object[] fila = new Object[4];
                fila[0] = p.getId();
                fila[1] = p.getNombre();
                fila[2] = p.getApellido();
                fila[3] = p.getDni();
                model.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos");
        }
    }

    private void imprimirPDF() throws DocumentException {
        String path = "src/main/java/org/zamasDev/pdf/ReporteTransacciones.pdf";

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));

            doc.open();

            Image image = com.itextpdf.text.Image.getInstance("src/main/java/org/zamasDev/pdf/logo.png");
            image.scaleAbsolute(100, 100);
            image.setAlignment(Element.ALIGN_CENTER);

            doc.add(new Paragraph("Reporte de Transacciones", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY)));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            doc.add(new Paragraph("Fecha: " + dtf.format(now), FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY)));
            doc.add(image);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.addCell("Codigo");
            table.addCell("Nombres");
            table.addCell("Apellidos");
            table.addCell("DNI");

            table.addCell(txtCodigoTran.getText());
            table.addCell(txtNombres.getText());

            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(path));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
