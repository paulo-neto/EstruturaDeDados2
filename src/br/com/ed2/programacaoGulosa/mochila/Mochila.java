package br.com.ed2.programacaoGulosa.mochila;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Mochila {
	int capacidade;
	double lucro;
	Produto produtos[];
	
	public Mochila(File arquivo) throws FileNotFoundException{
		Scanner leitor = new Scanner(arquivo);
		produtos = new Produto[leitor.nextInt()];
		capacidade = leitor.nextInt();
		
		for(int i = 0; i < produtos.length; i++){
			Produto umProduto = new Produto(leitor.nextInt(),leitor.nextInt());
			produtos[i] = umProduto;
		}
	}
	
}
