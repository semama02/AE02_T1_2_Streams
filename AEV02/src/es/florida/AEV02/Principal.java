package es.florida.AEV02;

public class Principal {

	//Constructor/mètode: main
	//Descripció: Inicialitzem el programa
	//Parametres d'entrada: ningun
	//Parametres d'eixida: ningun
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo,vista);
	}

}
