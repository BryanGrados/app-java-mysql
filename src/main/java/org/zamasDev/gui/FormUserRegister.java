package org.zamasDev.gui;

import org.zamasDev.utils.Decorations;
import org.zamasDev.validaciones.user.ValidateUserForm;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FormUserRegister extends JFrame {

    private int xMouse, yMouse;
    private JPanel contentPane;
    private JPanel panel;
    private JPasswordField txtPassword, txtConfirmedPassword;
    private JLabel lblViewPassword, lblRegister, lblSubmit, lblClose, lblLogin, lblHero;
    private JTextField txtEmail, txtUsername;
    private JSeparator spUsername, spPassword, spLoginAccount, spConfirmPassword, spEmail;
    private JLabel lblViewConfirmedPassword;

    Decorations decorations = new Decorations();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormUserRegister frame = new FormUserRegister();
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
    public FormUserRegister() {
        setUndecorated(true);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 780, 531);
        contentPane = new JPanel();
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
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(407, 11, 347, 509);
        contentPane.add(panel);
        panel.setLayout(null);

        spUsername = new JSeparator();
        spUsername.setBounds(10, 131, 327, 2);
        panel.add(spUsername);

        spEmail = new JSeparator();
        spEmail.setBounds(10, 211, 327, 2);
        panel.add(spEmail);

        spPassword = new JSeparator();
        spPassword.setBounds(10, 291, 327, 2);
        panel.add(spPassword);

        spConfirmPassword = new JSeparator();
        spConfirmPassword.setBounds(10, 377, 327, 2);
        panel.add(spConfirmPassword);

        spLoginAccount = new JSeparator();
        spLoginAccount.setBounds(70, 496, 207, 2);
        panel.add(spLoginAccount);

        lblHero = new JLabel("");
        lblHero.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/hero.png"));
        lblHero.setBounds(10, 41, 323, 440);
        contentPane.add(lblHero);

        lblClose = new JLabel("");
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblCloseMousePressed(e);
            }
        });
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblClose.setHorizontalAlignment(SwingConstants.CENTER);
        lblClose.setHorizontalTextPosition(SwingConstants.CENTER);
        lblClose.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/close.png"));
        lblClose.setBounds(10, 11, 46, 24);
        contentPane.add(lblClose);

        lblSubmit = new JLabel("Register");
        lblSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblSubmitMousePressed(e);
            }
        });
        lblSubmit.setForeground(new Color(0, 0, 0));
        lblSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSubmit.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
        lblSubmit.setBackground(new Color(255, 255, 255));
        lblSubmit.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubmit.setBounds(70, 423, 207, 35);
        panel.add(lblSubmit);

        lblRegister = new JLabel("Already have a account? Login");
        lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblRegisterMousePressed(e);
            }
        });
        lblRegister.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setBounds(10, 469, 327, 29);
        panel.add(lblRegister);

        lblLogin = new JLabel("Admin Auth");
        lblLogin.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(10, 36, 327, 43);
        panel.add(lblLogin);

        lblViewPassword = new JLabel("");
        lblViewPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblViewPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblViewPasswordMouseClicked(e);
            }
        });
        lblViewPassword.setHorizontalTextPosition(SwingConstants.CENTER);
        lblViewPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblViewPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-open.png"));
        lblViewPassword.setBounds(291, 250, 46, 43);
        panel.add(lblViewPassword);

        lblViewConfirmedPassword = new JLabel("");
        lblViewConfirmedPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblViewConfirmedPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblViewConfirmedPasswordMouseClicked(e);
            }
        });
        lblViewConfirmedPassword.setHorizontalTextPosition(SwingConstants.CENTER);
        lblViewConfirmedPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblViewConfirmedPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-open.png"));
        lblViewConfirmedPassword.setBounds(291, 336, 46, 43);
        panel.add(lblViewConfirmedPassword);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
        txtUsername.setOpaque(false);
        txtUsername.setBounds(10, 90, 327, 43);
        txtUsername.setColumns(10);
        txtUsername.setText("Username");
        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtUsernameFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtUsernameFocusLost(e);
            }
        });
        panel.add(txtUsername);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setOpaque(false);
        txtPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        txtPassword.setBounds(10, 250, 284, 43);
        txtPassword.setText("Password");
        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtPasswordFocusGained(e);
            }

            public void focusLost(FocusEvent e) {
                txtPasswordFocusLost(e);
            }
        });
        txtPassword.setEchoChar((char) 0);
        panel.add(txtPassword);

        txtEmail = new JTextField();
        txtEmail.setOpaque(false);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setColumns(10);
        txtEmail.setBorder(new EmptyBorder(5, 5, 5, 5));
        txtEmail.setBounds(10, 170, 327, 43);
        txtEmail.setText("Email");
        txtEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtEmailFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtEmailFocusLost(e);
            }
        });
        panel.add(txtEmail);

        txtConfirmedPassword = new JPasswordField();
        txtConfirmedPassword.setOpaque(false);
        txtConfirmedPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmedPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        txtConfirmedPassword.setBounds(10, 336, 284, 43);
        txtConfirmedPassword.setText("Confirm Password");
        txtConfirmedPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtConfirmedPasswordFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtConfirmedPasswordFocusLost(e);
            }
        });
        txtConfirmedPassword.setEchoChar((char) 0);
        panel.add(txtConfirmedPassword);

        this.setFocusable(true);
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


    protected void lblCloseMousePressed(MouseEvent e) {
        this.dispose();
    }

    protected void lblSubmitMousePressed(MouseEvent e) {
        ValidateUserForm validateUserForm = new ValidateUserForm();
        validateUserForm.validatedUserForm(txtUsername, txtEmail, txtPassword, txtConfirmedPassword, spUsername, spEmail, spPassword, spConfirmPassword);
    }

    protected void lblRegisterMousePressed(MouseEvent e) {
        this.dispose();
        new FormUserLogin().setVisible(true);
    }

    private void txtUsernameFocusGained(FocusEvent evt) {
        if (Objects.equals(txtUsername.getText(), "Username")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.BLACK);
            decorations.setSeparatorColor(spUsername, Color.BLACK);
        }
    }

    private void txtUsernameFocusLost(FocusEvent evt) {
        if (txtUsername.getText().isEmpty()) {
            txtUsername.setText("Username");
        }
    }

    protected void txtPasswordFocusGained(FocusEvent e) {
        if (txtPassword.getText().equals("Password")) {
            txtPassword.setText("");
            txtPassword.setEchoChar('•');
            txtPassword.setForeground(Color.BLACK);
            decorations.setSeparatorColor(spPassword, Color.BLACK);
        }
    }

    protected void txtPasswordFocusLost(FocusEvent e) {
        if (txtPassword.getText().equals("")) {
            txtPassword.setText("Password");
            txtPassword.setEchoChar((char) 0);
        }
    }

    protected void txtEmailFocusGained(FocusEvent e) {
        if (txtEmail.getText().equals("Email")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.BLACK);
            decorations.setSeparatorColor(spEmail, Color.BLACK);
        }
    }

    protected void txtEmailFocusLost(FocusEvent e) {
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("Email");
        }
    }

    protected void txtConfirmedPasswordFocusGained(FocusEvent e) {
        if (txtConfirmedPassword.getText().equals("Confirm Password")) {
            txtConfirmedPassword.setText("");
            txtConfirmedPassword.setEchoChar('•');
            txtConfirmedPassword.setForeground(Color.BLACK);
            decorations.setSeparatorColor(spConfirmPassword, Color.BLACK);
        }
    }

    protected void txtConfirmedPasswordFocusLost(FocusEvent e) {
        if (txtConfirmedPassword.getText().equals("")) {
            txtConfirmedPassword.setText("Confirm Password");
            txtConfirmedPassword.setEchoChar((char) 0);
        }
    }

    protected void lblViewPasswordMouseClicked(MouseEvent e) {
        if (txtPassword.getEchoChar() == (char) 0) {
            txtPassword.setEchoChar('•');
            lblViewPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-close.png"));
        } else {
            txtPassword.setEchoChar((char) 0);
            lblViewPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-open.png"));
        }
    }

    protected void lblViewConfirmedPasswordMouseClicked(MouseEvent e) {
        if (txtConfirmedPassword.getEchoChar() == (char) 0) {
            txtConfirmedPassword.setEchoChar('•');
            lblViewConfirmedPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-close.png"));
        } else {
            txtConfirmedPassword.setEchoChar((char) 0);
            lblViewConfirmedPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-open.png"));
        }
    }

}
