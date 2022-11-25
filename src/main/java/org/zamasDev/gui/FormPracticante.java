package org.zamasDev.gui;

import com.toedter.calendar.JDateChooser;
import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.mantenimiento.GestionPracticanteDAO;

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
	private JLabel lblIdPostulante;
	private JTextField txtIdPostulante;
	private JLabel lblFechaIngreso;
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
		lblCodigo.setBounds(10, 77, 139, 20);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(159, 77, 79, 22);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNombre.setBounds(10, 108, 139, 20);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(159, 108, 116, 22);
		panel.add(txtNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblApellido.setBounds(10, 139, 139, 20);
		panel.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(159, 139, 116, 22);
		panel.add(txtApellido);

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

		lblFechaIngreso = new JLabel("FechaIngreso");
		lblFechaIngreso.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblFechaIngreso.setBounds(327, 108, 116, 20);
		panel.add(lblFechaIngreso);

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

		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblSueldo.setBounds(327, 139, 116, 20);
		panel.add(lblSueldo);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(453, 140, 139, 22);
		panel.add(txtSueldo);

		lblIdPostulante = new JLabel("ID_Postulante");
		lblIdPostulante.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblIdPostulante.setBounds(10, 170, 139, 20);
		panel.add(lblIdPostulante);

		txtIdPostulante = new JTextField();
		txtIdPostulante.setEnabled(false);
		txtIdPostulante.setColumns(10);
		txtIdPostulante.setBounds(159, 170, 79, 22);
		panel.add(txtIdPostulante);

		txtFechaIngreso = new JDateChooser();
		txtFechaIngreso.setBounds(453, 108, 139, 20);
		panel.add(txtFechaIngreso);

		cargarDatos();
		limpiarCampos();
		setIncrementedCodigo();
	}

	//Methods

	protected void btnRegistrarActionPerformed(ActionEvent e) {

	}

	protected void btnActualizarActionPerformed(ActionEvent e) {

	}

	protected void btnEliminarActionPerformed(ActionEvent e) {

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
		List<EntityPracticante> practicantes = new ArrayList<EntityPracticante>();

		for (EntityPracticante practicante : practicantes) {
			Object[] datos = new Object[9];
			datos[0] = practicante.getId();
			datos[1] = practicante.getNombre();
			datos[2] = practicante.getApellido();
			datos[3] = practicante.getFechaIngreso();
			datos[4] = practicante.getSueldo();
			datos[5] = practicante.getIdPostulante();

			model.addRow(datos);
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
			txtIdPostulante.setText(idPostulante);
		}
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtFechaIngreso.setDate(null);
		txtSueldo.setText("");
		txtIdPostulante.setText("");
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

}


