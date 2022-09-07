package app.view;

import javax.swing.JFrame;

public class view extends JFrame{
	
	private PanelInicio pInicial;


	private PanelPrincipal pPrincipal;
	/**
	 * Constructor de la clase View 
	 */
	public view()
	{	
		
		setSize(800,550);
		setTitle("Base de Datos para Nomina");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializarComponentes();
		setVisible(true);
		
	}
	/**
	 * Este metodo se encarga de inicializar componentes y es implementando de la interface Size
	 * 
	 */
	
	public void inicializarComponentes() {
		pInicial = new PanelInicio();
		pInicial.setVisible(true);
		
		pPrincipal = new PanelPrincipal();
		pPrincipal.setVisible(false);
		
		
		getContentPane().add(pInicial);
		getContentPane().add(pPrincipal);
	}

	public PanelInicio getpInicial() {
		return pInicial;
	}

	public void setpInicial(PanelInicio pInicial) {
		this.pInicial = pInicial;
	}

	public void setpPrincipal(PanelPrincipal pPrincipal) {
		this.pPrincipal = pPrincipal;
	}
	public PanelPrincipal getpPrincipal() {
		return pPrincipal;
	}
}

