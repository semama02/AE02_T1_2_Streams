package es.florida.AEV02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerContar, actionListenerReemplazar;
	private String fitxerLlectura, fitxerEscriptura;
	
	//Constructor/mètode: Controlador
	//Descripció: passem la clase modelo, vista i executem control
	//Parametres d'entrada: modelo i vista
	//Parametres d'eixida: ningun
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}
	
	//Constructor/mètode: control
	//Descripció: creem l'opció de llegir quan es pulsen els botons
	//Parametres d'entrada: ningun
	//Parametres d'eixida: ningun
	public void control() {
		fitxerLlectura = modelo.fitxerLlectura();
		fitxerEscriptura = modelo.fitxerEscriptura();
		
		mostrarFitxer(fitxerLlectura,1);
		
		actionListenerContar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String paraula = vista.getTextFieldBuscar().getText();
				JOptionPane.showMessageDialog(null,"Apareix " +  modelo.btnBuscar(paraula) + " vegades");
			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerContar);
				
		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String paraula = vista.getTextFieldBuscar().getText();
				String reemplazar = vista.getTextFieldReemplazar().getText();
				modelo.BtnReemplazar(vista.getTextFieldReemplazar().getText(), vista.getTextFieldBuscar().getText());
				mostrarFitxer(fitxerEscriptura,2);
			}
		};
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);

	}
	
	//Constructor/mètode: mostrarFitxer
	//Descripció: mostrem el text de llectura
	//Parametres d'entrada: fitxer, numeroTextArea
	//Parametres d'eixida: mostrar text en pantalla
	private void mostrarFitxer(String fitxer, int numeroTextArea) {
		ArrayList<String> arrayLineas = modelo.contingutFitxer(fitxer);
		for(String linea : arrayLineas) {
			if (numeroTextArea == 1) {
				vista.getTextAreaOriginal().append(linea+"\n");
			}else {
				vista.getTextAreaModificado().append(linea+"\n");
			}
		}
	}
	
	
}
