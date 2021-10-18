package es.florida.AEV02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Modelo {
	private String fitxer_llectura;
	private String fitxer_escriptura;

	//Constructor/mètode: Modelo
	//Descripció: Pasem els arxius a utilitzar
	//Parametres d'entrada: ningun
	//Parametres d'eixida: ningun
	public Modelo() {
		fitxer_llectura = "AE02_T1_2_Streams_Groucho.txt";
		fitxer_escriptura = "AE02_T1_2_Streams_Groucho2.txt";
	}
	
	//Constructor/mètode: contingutFitxer
	//Descripció: Creem la forma de guardar linea per linea el arxiu que llegim
	//Parametres d'entrada: fitxer
	//Parametres d'eixida: el contingut del fitxer
	 public ArrayList<String> contingutFitxer(String fitxer){
		 ArrayList<String> contingutFitxer = new ArrayList<String>();
		 File f = new File(fitxer);
		 try {
			 FileReader fr = new FileReader(f);
			 BufferedReader br = new BufferedReader(fr);
			 String linea = br.readLine();
			 while (linea != null) {
				 contingutFitxer.add(linea);
				 linea = br.readLine();
			 }
			 br.close();
			 fr.close();
		 }catch (Exception e) {
			 JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			 
		 }
		 return contingutFitxer;
	 }
	 
	//Constructor/mètode: btnBuscar
	//Descripció: Programem lo que volem fer al pulsar el botó buscar
	//Parametres d'entrada: paraula
	//Parametres d'eixida: contador
	 public int btnBuscar(String paraula) {
		 int contador = 0, pos;
		 
		 for (int i = 0; i < contingutFitxer(fitxer_llectura).size(); i++) {
			 String x1 = contingutFitxer(fitxer_llectura).get(i);
			 String x2 = x1.trim();
			 if (x2.isEmpty()) {
				 contador=0;
			 }else {
				 pos = x2.indexOf(paraula);
				 while (pos != -1) {
					 contador++;
					 pos = x2.indexOf(paraula, pos + 1);
				 }
			 }
		 }
		 return contador;
	 }
	 
	//Constructor/mètode: fitxerEscriptura
	//Descripció: Guardem el fitxer d'escriptura
	//Parametres d'entrada: ningun
	//Parametres d'eixida: fitxer_escriptura
	 public String fitxerEscriptura() {
		 return fitxer_escriptura;
	 }
	 
	//Constructor/mètode: fitxerLlectura
	//Descripció: Guardem el fitxer de llectura
	//Parametres d'entrada: ningun
	//Parametres d'eixida: fitxer_llectura
	 public String fitxerLlectura() {
		 return fitxer_llectura;
	 }
	 
	//Constructor/mètode: BtnReemplazar
	//Descripció: Fem que llegeixi el arxiu llectura y linea a linea, reemplaci la paraula pero lo que volem i el guarde en el fitxer que crea
	//Parametres d'entrada: reemplazar i paraula
	//Parametres d'eixida: fitxer_escriptura(modificat)
	 public void BtnReemplazar(String reemplazar, String paraula) {
		 File f1 = new File(fitxerLlectura());
		 File f2 = new File(fitxerEscriptura());
		 try {
			 FileReader fr = new FileReader(f1);
			 BufferedReader br = new BufferedReader(fr);
			 FileWriter fw = new FileWriter(f2);
			 BufferedWriter bw = new BufferedWriter(fw);
			 String linea = br.readLine();
			 while (linea != null) {
				 bw.write(linea.replaceAll(paraula, reemplazar));
				 bw.newLine();
				 linea = br.readLine();
			 }
			 br.close();
			 fr.close();
			 bw.close();
			 fw.close();
			 f2.createNewFile();
		 } catch (Exception e) {
			 JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		 }
	 }
	 
}
