package views;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.HuespedesController;
import controller.ReservasController;
import modelo.Huespedes;
import modelo.Reserva;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtIdReserva;
	private JDateChooser txtFechaNacimiento;
	private JComboBox<Format> txtNacionalidad;
	private HuespedesController huespedesController;
	private ReservasController reservasController;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param integer 
	 * @param SystemColor 
	 */
	public RegistroHuesped(Integer integer, Color SystemColor) {
		this.huespedesController = new HuespedesController();
		new ReservasController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(SystemColor);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
			
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);
		
		txtFechaNacimiento = new JDateChooser();
		txtFechaNacimiento.setBounds(560, 278, 285, 36);
		txtFechaNacimiento.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaNacimiento.getCalendarButton().setBackground(SystemColor.BLUE);
		txtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaNacimiento);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36); 
		txtNacionalidad.setBackground(SystemColor.BLUE);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		contentPane.add(txtNacionalidad);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(562, 119, 253, 14);
		lblNombre.setForeground(SystemColor.BLACK);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 189, 255, 14);
		lblApellido.setForeground(SystemColor.BLACK);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);
		
		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 256, 255, 14);
		lblFechaN.setForeground(SystemColor.BLACK);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.BLACK);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.BLACK);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRO HUÉSPED");
		lblNewLabel_4.setBounds(606, 55, 234, 42);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblIdReserva = new JLabel("NÚMERO DE RESERVA");
		lblIdReserva.setBounds(560, 474, 253, 14);
		lblIdReserva.setForeground(SystemColor.BLACK);
		lblIdReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblIdReserva);
		
		txtIdReserva = new JTextField();
		
		txtIdReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtIdReserva.setBounds(560, 495, 285, 33);
		txtIdReserva.setColumns(10);
		txtIdReserva.setBackground(Color.WHITE);
		txtIdReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtIdReserva.setEditable(false);
		System.out.println(txtIdReserva);
		String id = String.valueOf(txtIdReserva);
		txtIdReserva.setText(id);
		contentPane.add(txtIdReserva);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarHuesped();
			}
		});
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png")));
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		contentPane.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.white);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
	}
	

	public RegistroHuesped(int i) {
		// TODO Auto-generated constructor stub
	}

	public RegistroHuesped() {
		// TODO Auto-generated constructor stub
	}

	private void guardarHuesped() {
		
		if (txtFechaNacimiento.getDate() != null && !txtNombre.equals("") && !txtApellido.equals("") && !txtTelefono.equals("")) {		
			String fechaNacimiento = ((JTextField)txtFechaNacimiento.getDateEditor().getUiComponent()).getText();	
			int IdReserva = Integer.parseInt(txtIdReserva.getText());
			Huespedes huespedes = new Huespedes(txtNombre.getText(), txtApellido.getText(),  java.sql.Date.valueOf(fechaNacimiento), txtNacionalidad.getSelectedItem().toString(),txtTelefono.getText(), IdReserva);
			this.huespedesController.guardar(huespedes);
			Exito exito = new Exito();
			exito.setVisible(true);	
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
		}
	
}
											
}
