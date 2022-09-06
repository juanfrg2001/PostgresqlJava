package app.view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelPrincipal extends JPanel{

	private JLabel fondo;
	private JLabel fondocliente;
	private JButton consulta1;
	private JButton Consulta2;
	private JButton Consulta3;
	private JButton consulta4;
	private JButton conectarBD;
	private JButton cargartxt;
	private JTextArea outputarea;
	private JLabel outputL;
	private JButton CargarBD;
	
	/**
	 * Constructor de la clase PanelCliente
	 */
	public PanelPrincipal()
	{
		setSize(800,550);
		setLayout(null);
		
		inicializarComponentes();
	}
	/**
	 * Este metodo se encarga de inicializar componentes y es implementando de la interface Size
	 * 
	 */
	
	public void inicializarComponentes() {
		
		fondo = new JLabel();
		fondo.setSize(800,550);
		
		fondocliente = new JLabel();
		fondocliente.setBounds(30,30,720,450);
		
		consulta1 = new JButton("Consulta 1");
		consulta1.setBounds(35,230,172,42);
		
		Consulta2 = new JButton("Consulta 2");
		Consulta2.setBounds(35,270,172,42);
		
		Consulta3 = new JButton("Consulta 3");
		Consulta3.setBounds(35,310,172,42);
		
		consulta4 = new JButton("Consulta 4");
		consulta4.setBounds(35,350,172,42);
		
		cargartxt = new JButton("Cargar txt");
		cargartxt.setBounds(35,25,172,42);
		
		cargartxt = new JButton("Cargar txt");
		cargartxt.setBounds(35,25,172,42);

		CargarBD = new JButton("Crear BD");
		CargarBD.setBounds(520,25,172,42);
		
		conectarBD = new JButton("Conectar BD");
		conectarBD.setBounds(270,25,172,42);
	
		outputL = new JLabel("OUTPUT");
		outputL.setBounds(245,215,120,20);
		
		outputarea = new JTextArea();
		outputarea.setBounds(245,230,500,500);
		

		
		add(fondo);
		fondo.add(fondocliente);
		fondocliente.add(consulta1);
		fondocliente.add(Consulta2);
		fondocliente.add(Consulta3);
		fondocliente.add(consulta4);
		fondocliente.add(outputL);
		fondocliente.add(cargartxt);
		fondocliente.add(CargarBD);
		fondocliente.add(conectarBD);
		fondocliente.add(outputarea);
	}
	public JLabel getFondocliente() {
		return fondocliente;
	}
	public JButton getInfo() {
		return consulta1;
	}
	public JButton getPareja() {
		return Consulta2;
	}
	public JButton getCredito() {
		return Consulta3;
	}
	public JButton getCerrar() {
		return consulta4;
	}

	public JButton getSolicitarsobrecupo() {
		return cargartxt;
	}
	public JButton getGenerarextracto() {
		return CargarBD;
	}
}
	
	
	

