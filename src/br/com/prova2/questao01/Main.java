package br.com.prova2.questao01;

public class Main {	
	public static void main(String[] args) {
		
		MatrizCidades matriz = new MatrizCidades();
		matriz.readFile("distancias.txt");
		matriz.menorCaminhoGuloso(0, 7);

	}

}
