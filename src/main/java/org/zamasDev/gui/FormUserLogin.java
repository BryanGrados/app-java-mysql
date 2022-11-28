package org.zamasDev.gui;

import org.zamasDev.utils.Decorations;
import org.zamasDev.validaciones.user.ValidateUserLoginForm;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.Objects;

public class FormUserLogin extends JFrame {

	private int xMouse, yMouse;
	private JPanel contentPane, panel;
	private JLabel hero, lblLogin, lblClose, lblSubmit, lblRegister, lblViewPassword;
	private  JSeparator spUser, spPass, spAccount;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	Decorations decorations = new Decorations();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUserLogin frame = new FormUserLogin();
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
	public FormUserLogin() {
		setUndecorated(true);
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


		panel = new JPanel();
		panel.setBounds(407, 11, 347, 470);
		panel.setLayout(null);
		contentPane.add(panel);

		spUser = new JSeparator();
		spUser.setBounds(10, 180, 327, 2);
		panel.add(spUser);

		spPass = new JSeparator();
		spPass.setBounds(10, 300, 327, 2);
		panel.add(spPass);


		spAccount = new JSeparator();
		spAccount.setBounds(70, 457, 207, 2);
		panel.add(spAccount);

		hero = new JLabel("");
		hero.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/hero.png"));
		hero.setBounds(10, 41, 323, 440);
		contentPane.add(hero);

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

		lblSubmit = new JLabel("Login");
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
		lblSubmit.setBounds(70, 370, 207, 35);
		panel.add(lblSubmit);

		lblRegister = new JLabel("Not registered yet? Create a account");
		lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblRegisterMousePressed(e);
			}
		});
		lblRegister.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(10, 430, 327, 29);
		panel.add(lblRegister);

		lblLogin = new JLabel("Admin Login");
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 45, 327, 43);
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
		lblViewPassword.setIcon(new ImageIcon("src/main/java/org/zamasDev/img/eye-close.png"));
		lblViewPassword.setBounds(291, 259, 46, 43);
		panel.add(lblViewPassword);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtUsername.setOpaque(false);
		txtUsername.setBounds(10, 139, 327, 43);
		txtUsername.setColumns(10);
		txtUsername.setText("Username or Email");
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
		txtPassword.setBounds(10, 259, 284, 43);
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
	protected void lblRegisterMousePressed(MouseEvent e) {
		this.dispose();
		new FormUserRegister().setVisible(true);
	}
	protected void lblSubmitMousePressed(MouseEvent e) {
		ValidateUserLoginForm validateUserLoginForm = new ValidateUserLoginForm();
		if (validateUserLoginForm.validateUserLogin(txtUsername, txtPassword, spUser, spPass)) {
			this.dispose();
			this.setVisible(false);
		}
	}

	private void txtUsernameFocusGained(FocusEvent evt) {
		if (Objects.equals(txtUsername.getText(), "Username or Email")) {
			txtUsername.setText("");
			txtUsername.setForeground(Color.BLACK);
			decorations.setSeparatorColor(spUser, Color.BLACK);
		}
	}

	private void txtUsernameFocusLost(FocusEvent evt) {
		if (txtUsername.getText().isEmpty()) {
			txtUsername.setText("Username or Email");
		}
	}

	private void txtPasswordFocusGained(FocusEvent evt) {
		if (String.valueOf(txtPassword.getPassword()).equals("Password")) {
			txtPassword.setText("");
			txtPassword.setEchoChar('•');
			txtPassword.setForeground(Color.BLACK);
			decorations.setSeparatorColor(spPass, Color.BLACK);
		}
	}

	private void txtPasswordFocusLost(FocusEvent evt) {
		if (String.valueOf(txtPassword.getPassword()).equals("")) {
			txtPassword.setText("Password");
			txtPassword.setEchoChar((char) 0);
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
}
