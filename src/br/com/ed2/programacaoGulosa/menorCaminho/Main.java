package br.com.ed2.programacaoGulosa.menorCaminho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	Mapa mapa;
	
	
	public static void main(String[] args) {
		
		
		Main main = new Main();
		
//		int random = 0;
//		for (int i = 0; i < 10; i++) {
//			random = (int)(Math.random()*5)%10;
//			System.out.println(random);
//		}
//		System.exit(0);
		
		main.lerArquivo("distancias_4.txt");
		
		System.out.println("\n\n********  Solução para 4 cidades (Método Guloso) ********");
		long time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoGulosa(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("****************************************************************");
		
		System.out.println("\n\n********  Solução para 4 cidades (Método totalmente aleatório) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoria(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
		
		System.out.println("\n\n********  Solução para 4 cidades (Método aleatório analisando 10 soluções) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoriaMelhor(0, 10));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
				

		main.lerArquivo("distancias_177.txt");
		
		System.out.println("\n\n********  Solução para 177 cidades (Método Guloso) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoGulosa(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("****************************************************************");
		
		System.out.println("\n\n********  Solução para 177 cidades (Método totalmente aleatório) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoria(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
		
		// Menor percurso registrado (236.059 km)
		System.out.println("\n\n********  Solução para 177 cidades (Método aleatório analisando 1.000 soluções) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoriaMelhor(0, 1000));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
		
		
		main.lerArquivo("distancias_7.txt");
		
		System.out.println("\n\n********  Solução para 7 cidades (Método Guloso) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoGulosa(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("****************************************************************");
		
		System.out.println("\n\n********  Solução para 7 cidades (Método totalmente aleatório) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoria(0));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
		
		System.out.println("\n\n********  Solução para 7 cidades (Método aleatório analisando 100 soluções) ********");
		time = System.currentTimeMillis();		
		System.out.println(main.mapa.getSolucaoAleatoriaMelhor(0, 1000));
		System.out.println("Tempo: " + ((System.currentTimeMillis() - time)/1000) + " segundos");
		System.out.println("******************************************************************************");
		
	}
	
	
	public void lerArquivo(String filename) {
		
		File file;
		try {
			file = new File(filename);
			
			if (file.exists()) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
				String [] strlst = br.readLine().split(" ");
				
				mapa = new Mapa(Integer.parseInt(strlst[0]));
								
				int contLine = 0;
				
				while (br.ready()) {
					
					strlst = br.readLine().split(" ");
					double [] tmpdouble = new double [strlst.length];
					for (int i = 0; i < strlst.length; i++) {
						tmpdouble[i] = Double.parseDouble(strlst[i]);
					}					
					mapa.setLinhaMatriz(contLine, tmpdouble);
					contLine++;
					
				}
				strlst = null;
				br.close();
			}			
		} catch (IOException e) {
			System.out.println("[lerArquivo] - Erro na leitura do arquivo.\n");
			e.printStackTrace();
		}
		
		
		//mochila = new Mochila(qtd_prods, _capacidade)
		
	}

}
