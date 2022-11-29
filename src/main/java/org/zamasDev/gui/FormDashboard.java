package org.zamasDev.gui;

import org.zamasDev.utils.Decorations;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.*;

public class FormDashboard extends JFrame {

    private int xMouse, yMouse;
    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblAstronaut;
    private JLabel lblSpace;
    private JLabel lblPortal;
    private JLabel lblTitle;
    private JLabel lblMantenimientos;
    private JLabel lblConsultas;
    private JLabel lblTransacciones;
    private JSeparator sp_registro;
    private JSeparator sp_consulta;
    private JSeparator sp_transaccion;
    private JLabel lblIconConsultas;
    private JLabel lblIconRegistros;
    private JLabel lblIconTransacciones;
    private JLabel lblClose;

    Decorations decorations = new Decorations();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormDashboard frame = new FormDashboard();
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
    public FormDashboard() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1044, 650);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getLocation().x + e.getX() - xMouse, getLocation().y + e.getY() - yMouse);
            }
        });
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(0, 0, 1044, 661);
        contentPane.add(panel);
        panel.setLayout(null);

        lblAstronaut = new JLabel("");
        lblAstronaut.setHorizontalAlignment(SwingConstants.CENTER);
        lblAstronaut.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/space.png"));
        lblAstronaut.setBounds(742, 429, 292, 210);
        panel.add(lblAstronaut);

        lblSpace = new JLabel("");
        lblSpace.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/planet.png"));
        lblSpace.setBounds(766, 11, 268, 289);
        panel.add(lblSpace);

        lblPortal = new JLabel("");
        lblPortal.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/portal.png"));
        lblPortal.setBounds(20, 100, 268, 452);
        panel.add(lblPortal);

        lblTitle = new JLabel("Bienvenido al Panel");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(344, 67, 351, 70);
        panel.add(lblTitle);

        lblMantenimientos = new JLabel("Registros");
        lblMantenimientos.setBorder(null);
        lblMantenimientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblMantenimientosMousePressed(e);
            }
        });
        lblMantenimientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                decorations.Hover(lblMantenimientos);
            }
        });
        lblMantenimientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                decorations.HoverOut(lblMantenimientos);
            }
        });

        lblMantenimientos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMantenimientos.setHorizontalAlignment(SwingConstants.LEFT);
        lblMantenimientos.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblMantenimientos.setBounds(447, 207, 119, 26);
        panel.add(lblMantenimientos);

        lblConsultas = new JLabel("Consultas");
        lblConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblConsultasMousePressed(e);
            }
        });
        lblConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                decorations.Hover(lblConsultas);
            }
        });
        lblConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                decorations.HoverOut(lblConsultas);
            }
        });

        lblConsultas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblConsultas.setBorder(null);
        lblConsultas.setHorizontalAlignment(SwingConstants.LEFT);
        lblConsultas.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblConsultas.setBounds(447, 316, 119, 26);
        panel.add(lblConsultas);

        lblTransacciones = new JLabel("Transacciones");
        lblTransacciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblTransaccionesMousePressed(e);
            }
        });
        lblTransacciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                decorations.Hover(lblTransacciones);
            }
        });
        lblTransacciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                decorations.HoverOut(lblTransacciones);
            }
        });
        lblTransacciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTransacciones.setBorder(null);
        lblTransacciones.setHorizontalAlignment(SwingConstants.LEFT);
        lblTransacciones.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTransacciones.setBounds(447, 426, 127, 26);
        panel.add(lblTransacciones);

        sp_registro = new JSeparator();
        sp_registro.setBounds(447, 242, 161, 2);
        panel.add(sp_registro);

        sp_consulta = new JSeparator();
        sp_consulta.setBounds(447, 352, 161, 2);
        panel.add(sp_consulta);

        sp_transaccion = new JSeparator();
        sp_transaccion.setBounds(447, 463, 161, 2);
        panel.add(sp_transaccion);

        lblIconConsultas = new JLabel("");
        lblIconConsultas.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconConsultas.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/chart.png"));
        lblIconConsultas.setBounds(576, 315, 32, 27);
        panel.add(lblIconConsultas);

        lblIconRegistros = new JLabel("");
        lblIconRegistros.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/book.png"));
        lblIconRegistros.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconRegistros.setBounds(576, 207, 32, 27);
        panel.add(lblIconRegistros);

        lblIconTransacciones = new JLabel("");
        lblIconTransacciones.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/trans.png"));
        lblIconTransacciones.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconTransacciones.setBounds(576, 429, 32, 27);
        panel.add(lblIconTransacciones);

        lblClose = new JLabel("");
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblCloseMousePressed(e);
            }
        });
        lblClose.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/close.png"));
        lblClose.setHorizontalAlignment(SwingConstants.CENTER);
        lblClose.setBounds(20, 11, 46, 26);
        panel.add(lblClose);

        this.setFocusable(true);
        this.setResizable(false);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    lblCloseMousePressed(null);
                }
            }
        });
        this.setLocationRelativeTo(null);
    }

    protected void lblMantenimientosMousePressed(MouseEvent e) {
        Object[] options = {"Postulantes", "Practicantes", "Empleadores"};
        int n = JOptionPane.showOptionDialog(this,
                "Seleccione un mantenimiento",
                "Mantenimientos",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/main/java/org/zamasDev/img/book.png"),
                options,
                options[2]);
        if (n == 0) {
            FormPostulante formPostulante = new FormPostulante();
            formPostulante.setVisible(true);
        } else if (n == 1) {
            FormPracticante formPracticante = new FormPracticante();
            formPracticante.setVisible(true);
        } else if (n == 2) {
            FormEmpleador formEmpleador = new FormEmpleador();
            formEmpleador.setVisible(true);
        }
    }

    protected void lblConsultasMousePressed(MouseEvent e) {
        Object[] options = {"Postulantes", "Practicantes"};
        int n = JOptionPane.showOptionDialog(this,
                "Seleccione una consulta",
                "Consultas",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/main/java/org/zamasDev/img/chart.png"),
                options,
                options[1]);
        if (n == 0) {
            FormConsultaPostulantes formConsultaPostulante = new FormConsultaPostulantes();
            formConsultaPostulante.setVisible(true);
        } else {
            FormConsultaPracticantes formConsultaPracticante = new FormConsultaPracticantes();
            formConsultaPracticante.setVisible(true);
        }
    }

    protected void lblTransaccionesMousePressed(MouseEvent e) {
    }

    protected void lblCloseMousePressed(MouseEvent e) {
        this.dispose();
    }
}
