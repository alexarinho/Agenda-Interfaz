package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JLabel lblAgenda;
	private JLabel lblContacto;
	private JLabel lblTelefono;
	private JButton btnGuardar;
	private JRadioButton rdbtnAmigo;
	private JRadioButton rdbtnFamiliar;
	private final ButtonGroup buttonGroupPersona = new ButtonGroup();
	private JTextField textNombre;
	private JTextField textTlf;
	private Contacto vContactos[];
	private JButton btnBuscar;
	private JLabel lblInf;
	private JComboBox comboBox;
	private DefaultComboBoxModel modeloComboBox;
	private JButton btnBorrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		vContactos = new Contacto[10];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAgenda = new JLabel("AGENDA TELEFONO");
		lblAgenda.setForeground(new Color(0, 0, 0));
		lblAgenda.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setBounds(170, 28, 307, 42);
		contentPane.add(lblAgenda);
		
		lblContacto = new JLabel("Nuevo Nombre:");
		lblContacto.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblContacto.setBounds(62, 81, 111, 33);
		contentPane.add(lblContacto);
		
		lblTelefono = new JLabel("Nuevo Telefono:");
		lblTelefono.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblTelefono.setBounds(62, 141, 95, 26);
		contentPane.add(lblTelefono);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new BtnGuardarMouseListener());
		btnGuardar.setBackground(new Color(255, 215, 0));
		btnGuardar.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnGuardar.setBounds(62, 307, 111, 23);
		contentPane.add(btnGuardar);
		
		rdbtnAmigo = new JRadioButton("Amigo");
		rdbtnAmigo.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		rdbtnAmigo.setBackground(new Color(255, 215, 0));
		buttonGroupPersona.add(rdbtnAmigo);
		rdbtnAmigo.setBounds(62, 254, 109, 23);
		contentPane.add(rdbtnAmigo);
		
		rdbtnFamiliar = new JRadioButton("Familiar");
		rdbtnFamiliar.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		rdbtnFamiliar.setBackground(new Color(255, 215, 0));
		buttonGroupPersona.add(rdbtnFamiliar);
		rdbtnFamiliar.setBounds(62, 210, 109, 23);
		contentPane.add(rdbtnFamiliar);
		
		textNombre = new JTextField();
		textNombre.setBounds(62, 114, 111, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTlf = new JTextField();
		textTlf.setBounds(62, 168, 111, 20);
		contentPane.add(textTlf);
		textTlf.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new BtnBuscarMouseListener());
		btnBuscar.setBackground(Color.ORANGE);
		btnBuscar.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnBuscar.setBounds(259, 307, 101, 23);
		contentPane.add(btnBuscar);
		
		lblInf = new JLabel("Contacto:");
		lblInf.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblInf.setBounds(205, 147, 241, 14);
		contentPane.add(lblInf);
		
		comboBox = new JComboBox();
		modeloComboBox= new DefaultComboBoxModel();
		modeloComboBox.addElement("Contactos:");
		comboBox.setModel(modeloComboBox);
		
		comboBox.setBounds(259, 181, 101, 23);
		contentPane.add(comboBox);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new BtnBorrarMouseListener());
		btnBorrar.setBackground(Color.ORANGE);
		btnBorrar.setForeground(Color.BLACK);
		btnBorrar.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnBorrar.setBounds(459, 307, 89, 23);
		contentPane.add(btnBorrar);
	}
	private class BtnGuardarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String nombre;
			int telefono;
			boolean persona;
			
			nombre = textNombre.getText();
			telefono = Integer.parseInt(textTlf.getText());
			
			Contacto aux = new Contacto(nombre, telefono);
			for (int i = 0; i < vContactos.length; i++) {
				if(vContactos[i]==null) {
					vContactos[i]=aux;
					if(rdbtnAmigo.isSelected()) {
						vContactos[i].setPersona(true);
					} else {
						vContactos[i].setPersona(false);
					}
					break;
				}
			}
			textNombre.setText(nombre);
			textTlf.setText(Integer.toString(telefono));
			
			recargarDatos();
			/*modeloComboBox.removeAllElements();
			modeloComboBox.addElement("Contacto: ");
			
			for (Contacto contacto : vContactos) {
				if(contacto!=null) {
					modeloComboBox.addElement(contacto.toString());
				}
			}*/
			
			JOptionPane.showMessageDialog(null, "Contacto añadido", "Contacto", 3);
		}
	}
	private class BtnBuscarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int i = comboBox.getSelectedIndex();
			lblInf.setText(vContactos[i-1].toString());
		}
	}
	
	private class BtnBorrarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String i = (String)comboBox.getSelectedItem();
			for (int j = 0; j < vContactos.length; j++) {
				if(vContactos[j]!=null) {
					if(i.equalsIgnoreCase(vContactos[j].getNombre())) {
						vContactos[j]=null;
					}
				}
			}

			JOptionPane.showMessageDialog(null, "Contacto Borrado", "Borrar",3);
			recargarDatos();
		}
	}
	
	private void recargarDatos() {
		modeloComboBox.removeAllElements();
		modeloComboBox.addElement("Contactos");
		for (Contacto c : vContactos) {
			if (c!=null) {
				modeloComboBox.addElement(c.getNombre());
			}
		}
	}
	
}
