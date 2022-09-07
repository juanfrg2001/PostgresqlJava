package app.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelInicio extends JPanel{
	
	private JLabel fondo;
	private JLabel usuarioF;
	private JLabel claveF;
	private JButton registraraqui;
	private JButton login;
	private JTextField usuario;
	private JPasswordField clave;
	/**
	 * Constructor de la clase PanelPrincipal
	 */
	public PanelInicio()
	{
		setSize(800,550);
		setLayout(null);
		inicializarComponentes();
		setVisible(false);
		
	}
	/**
	 * Este metodo se encarga de inicializar componentes y es implementando de la interface Size
	 * 
	 */
	
	public void inicializarComponentes() {
		
		fondo = new JLabel();
		fondo.setSize(800,550);
		
		usuarioF = new JLabel("Usuario");
		usuarioF.setBounds(320,332,170,21);
		
		usuario = new JTextField();
		usuario.setBounds(320,352,170,21);
		usuario.setHorizontalAlignment(JTextField.CENTER);
		usuario.setFont(new Font("helvetica",Font.PLAIN,15));
		usuario.setBorder(null);
		
		claveF = new JLabel("Contraseña");
		claveF.setBounds(320,374,170,21);
		
		clave = new JPasswordField();
		clave.setBounds(320,394,170,21);
		clave.setHorizontalAlignment(JTextField.CENTER);
		clave.setFont(new Font("helvetica",Font.PLAIN,15));
		clave.setBorder(null);

		
		login = new JButton();
		login.setBounds(340,440,120,39);
		login.setText("INGRESAR");
		login.setBorder(null);
		
		
		add(fondo);
		fondo.add(usuarioF);
		fondo.add(claveF);
		fondo.add(login);
		fondo.add(usuario);
		fondo.add(clave);

		
	}


	public JButton getRegistraraqui() {
		return registraraqui;
	}


	public JButton getLogin() {
		return login;
	}


	public JTextField getUsuario() {
		return usuario;
	}


	public JPasswordField getClave() {
		return clave;
	}
	
}

