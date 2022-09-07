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



	private JButton consulta5;

	private JButton consulta6;
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
		setVisible(false);
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

		consulta5 = new JButton("Consulta 5");
		consulta5.setBounds(35,380,172,42);

		consulta6 = new JButton("Consulta 6");
		consulta6.setBounds(35,410,172,42);
		
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
		fondocliente.add(consulta5);
		fondocliente.add(consulta6);
		fondocliente.add(outputL);
		fondocliente.add(cargartxt);
		fondocliente.add(CargarBD);
		fondocliente.add(conectarBD);
		fondocliente.add(outputarea);
	}
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JLabel getFondocliente() {
		return fondocliente;
	}

	public void setFondocliente(JLabel fondocliente) {
		this.fondocliente = fondocliente;
	}

	public JButton getConsulta1() {
		return consulta1;
	}

	public void setConsulta1(JButton consulta1) {
		this.consulta1 = consulta1;
	}

	public JButton getConsulta2() {
		return Consulta2;
	}

	public void setConsulta2(JButton consulta2) {
		Consulta2 = consulta2;
	}

	public JButton getConsulta3() {
		return Consulta3;
	}

	public void setConsulta3(JButton consulta3) {
		Consulta3 = consulta3;
	}

	public JButton getConsulta4() {
		return consulta4;
	}

	public void setConsulta4(JButton consulta4) {
		this.consulta4 = consulta4;
	}

	public JButton getConectarBD() {
		return conectarBD;
	}

	public void setConectarBD(JButton conectarBD) {
		this.conectarBD = conectarBD;
	}

	public JButton getCargartxt() {
		return cargartxt;
	}

	public void setCargartxt(JButton cargartxt) {
		this.cargartxt = cargartxt;
	}

	public JTextArea getOutputarea() {
		return outputarea;
	}

	public void setOutputarea(JTextArea outputarea) {
		this.outputarea = outputarea;
	}

	public JLabel getOutputL() {
		return outputL;
	}

	public void setOutputL(JLabel outputL) {
		this.outputL = outputL;
	}

	public JButton getCargarBD() {
		return CargarBD;
	}

	public void setCargarBD(JButton cargarBD) {
		CargarBD = cargarBD;
	}

	public JButton getConsulta5() {
		return consulta5;
	}

	public void setConsulta5(JButton consulta5) {
		this.consulta5 = consulta5;
	}

	public JButton getConsulta6() {
		return consulta6;
	}

	public void setConsulta6(JButton consulta6) {
		this.consulta6 = consulta6;
	}

}
	
	
	

