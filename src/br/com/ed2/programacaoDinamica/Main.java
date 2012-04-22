package br.com.ed2.programacaoDinamica;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		int [] vetor =  new int []{23,85,48,90,10,4,27,11,55,1};
		Quick_Sort paulo = new Quick_Sort();
		
		System.out.println("Vetor inicial : \n");
		paulo.toString(vetor);
		System.out.println("\nOrdenando o Vetor com o Quick-Sort \n");
		paulo.vet = paulo.quickSort(vetor, 0, vetor.length - 1);
		paulo.toString(vetor);
		
		// Faz uma chamada a função responsável em obter o menor valor, e imprime o resultado 
		System.out.println("\nMenor elemento no Vetor = [" + paulo.menorElemento(vetor, 0,vetor.length-1)+"]");
		
		
		//Chama a função que verifica se um determinado valor está contido em um arranjo.
		int valor = 100;
		System.out.print("\nContém o valor " + valor + " ? ");
		if (paulo.contem(vetor, 0,vetor.length-1, valor)){
			System.out.println("Sim!");
		} else {
			System.out.println("Não!");
		}		
	}
}
