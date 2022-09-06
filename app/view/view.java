package app.view;

package co.edu.unbosque.view;

import javax.swing.JFrame;

public class View extends JFrame{
	
	private PanelInicio pInicial;
	private PanelPrincipal pPrincipal;
	/**
	 * Constructor de la clase View 
	 */
	public View()
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
		pInicial.setVisible(false);
		
		pPrincipal = new PanelPrincipal();
		pPrincipal.setVisible(true);
		
		
		getContentPane().add(pInicial);
		getContentPane().add(pPrincipal);
	}
		
	public PanelPrincipal getpPrincipal() {
		return pPrincipal;
	}
	
	public PanelInicio getpRegistro() {
		return pInicial;
	}
}
