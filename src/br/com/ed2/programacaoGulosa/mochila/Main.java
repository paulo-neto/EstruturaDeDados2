package br.com.ed2.programacaoGulosa.mochila;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Mochila m1 = new Mochila(new File("mochila_3.txt"));
		
		for(int i = 0; i < m1.produtos.length;i++){
			System.out.println("\nProduto :"+i+" Capacidade : "+m1.produtos[i].peso);
			System.out.println("\nProduto :"+i+" Lucro : "+m1.produtos[i].valor);
		}
		
		
	}

}
