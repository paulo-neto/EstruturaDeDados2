package br.ufpb.ed.pratica05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int[][] matriz;
		try {
			matriz = lerArquivo("distancias_4.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler o arquivo.");
			return;
		}
		
		Caxeiro caxeiro = new Caxeiro(matriz, 3);
		int[] rota = caxeiro.elaborarRotaGulosa();
		System.out.println(" ==== Guloso ====\n"+
						   " Cidades visitadas : ");
		for(int i:rota)
			System.out.print("  "+i + " ");
		System.out.println();
		
		System.out.println("\n======= Aleatória =======\n"+
						   " Cidades Visitadas : ");
		int random = (int)(Math.random()*5)%10;			
		if (random >= matriz.length) {
			random = 0;
		}
		Caxeiro outroCaxeiro = new Caxeiro(matriz, random);
		int[] rotaAleatoria = outroCaxeiro.elaborarRotaGulosa();
		for(int i:rotaAleatoria)
			System.out.print("  "+i + " ");
		System.out.println();
		
		
//		System.out.println(c.calcularDistanciaPercurso(rota));
		

	}
	
	public static int[][] lerArquivo(String nome) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(nome));
		int qtdeCidade = sc.nextInt();
		int[][] matriz = new int[qtdeCidade][qtdeCidade];
		for(int i = 0; i < qtdeCidade; ++i)
			for(int j= 0; j < qtdeCidade; ++j)
				matriz[i][j]= sc.nextInt();
		return matriz;
	}

}
