package br.com.ed2.programacaoGulosa.mochila;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Mochila mochila1 = new Mochila(new File("mochila_3.txt"));
		System.out.println("===>> Capacidade da Mochila : "+mochila1.capacidade+"\n");
		System.out.println("===>> Quantidade de Produtos : "+mochila1.numProdutos+"\n");
		System.out.println("===>> Solução com os produtos mais leves : "+mochila1.produtoMaisLeve()+"\n");
		
		Mochila mochila2 = new Mochila(new File("mochila_3.txt"));
		System.out.println("===>> Solução com os produtos de maior valor : "+mochila2.produtoMaisCaro()+"\n");
		
		Mochila mochila3 = new Mochila(new File("mochila_3.txt"));
		System.out.println("===>> Solução com a razão entre o valor/peso : "+mochila3.razao()+"\n");
		
		
		

		
	}

}
