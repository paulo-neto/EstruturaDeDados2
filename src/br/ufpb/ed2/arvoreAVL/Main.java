package br.ufpb.ed2.arvoreAVL;

import java.util.Scanner;

public class Main {

	/**
	 * @Paulo Antonio
	 */
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		TreeAVL av = new TreeAVL();
		int info;
		
		do{
			System.out.println("Valor :");
			info = leitor.nextInt();
			if(info !=-1){
				av.insere(info);
			}
		}while(info !=-1);
		av.caminhamentoPreOrdem(av.raiz);

	}

}
