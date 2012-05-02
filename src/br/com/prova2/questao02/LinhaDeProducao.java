package br.com.prova2.questao02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinhaDeProducao {

	private BufferedReader br;
	private File file;
	
	/*"linhaProducao" = linhas de producao e "estacao" = nº de estações*/
	private int linhaProducao, estacao; 
	
	private int [] entrada;
	
	private int [] saida; 
	
	/* Guarda os valores de cada tranferencia*/
	private int [][] transferencia;
	
	/*valores de processamento de cada sessão*/
	private int [][] processamento;
	
	 /*Guarda o cálculo do processamento + transferencia*/
	private int [][] tempoDeProducao;
	
	 /*linhas escolhidas na melhor producao*/
	private int [][] analise;
	
	
	
	private void inicializaEstruturas(int umaLinha, int umaEstacao){
		
		linhaProducao = umaLinha;
		estacao = umaEstacao;
		
		entrada = new int [linhaProducao];
		saida = new int [linhaProducao];
		processamento = new int [linhaProducao][estacao];
		transferencia = new int [linhaProducao][estacao-1];
		
		// inicializa o calculo de processamento com -1
		tempoDeProducao = new int [linhaProducao][estacao];	
		for (int k = 0; k < linhaProducao; k++) {
			for (int l = 0; l < estacao; l++) {
				tempoDeProducao[k][l] = -1;
			}
		}
		
		// inicializa as linhas produzidas com -1		
		analise = new int [linhaProducao][estacao-1];
		for (int k = 0; k < linhaProducao; k++) {
			for (int l = 0; l < (estacao-1); l++) {
				analise[k][l] = -1;
			}
		}
		
	}
	
	
	public void menorTempoDeProducao(){
				
		if (linhaProducao >= 2) { // Deve haver no mínimo 2 linhas de produção
			
			for (int k = 0; k < linhaProducao; k++) {
				/*inicializa a 1ª estação de cada linha de producao com o valor de entrada   entrada[][])*/
				tempoDeProducao[k][0] = processamento[k][0] + entrada[k];
			}
						
			for (int l = 0; l < linhaProducao-1; l++) {
				
				for (int c = 1; c < estacao; c++) {
					
					if ((tempoDeProducao[l][c-1] + processamento[l][c]) <= (tempoDeProducao[l+1][c-1] + transferencia[l+1][c-1] + processamento[l][c])){
						
						tempoDeProducao[l][c] = (tempoDeProducao[l][c-1] + processamento[l][c]);
						analise[l][c-1] = 1;
						
					} else {
						
						tempoDeProducao[l][c] = (tempoDeProducao[l+1][c-1] + transferencia[l+1][c-1] + processamento[l][c]);
						analise[l][c-1] = 2;
						
					}
					
					if ((tempoDeProducao[l+1][c-1] + processamento[l+1][c]) <= (tempoDeProducao[l][c-1] + transferencia[l][c-1] + processamento[l+1][c])){
						
						tempoDeProducao[l+1][c] = (tempoDeProducao[l+1][c-1] + processamento[l+1][c]);
						analise[l+1][c-1] = 2;
						
					} else {
						
						tempoDeProducao[l+1][c] = (tempoDeProducao[l][c-1] + transferencia[l][c-1] + processamento[l+1][c]);
						analise[l+1][c-1] = 1;
						
					}
					
				}
				
			}	
			/*imprime os cálculos de produção*/
			exibeCalculoDeProducao();
			
			if ((tempoDeProducao[0][estacao - 1] + saida[0]) <= (tempoDeProducao[1][estacao - 1] + saida[1])) {
				/*imprime a solução a partir da 1ª linha*/
				System.out.println("\nSOLUÇÃO PARTINDO DA PRIMEIRA LINHA :\n");
				exibeSolucao(0);
			} else {
				/*imprime a solução a partir da 2ª linha*/
				System.out.println("SOLUÇÃO PARTINDO DA SEGUNDA LINHA :\n");
				exibeSolucao(1);
			}
			
		} else {
			
			System.out.println("Só é possível calcular otimização do processo de produção para duas ou mais linhas de produção");
			
		}
	}
	
	private void exibeSolucao(int l){
		
		//System.out.println("SOLUÇÃO:\n");		
		exibeSolucao2(l, estacao-2);
		System.out.println("Estação nº" + estacao + " - Linha de montagem nº" + (l+1));
		
	}
	
	private void exibeSolucao2(int x, int y){
			
		if (y < 0)			
			return;		
				
		exibeSolucao2(((analise[x][y])-1), y-1);
		System.out.println("Estação nº" + (y+1) + " - Linha de montagem nº" + analise[x][y]);
		
	}
	
	private void exibeCalculoDeProducao(){
		
		System.out.println("\nMATRIZ COM OS TEMPOS DE PRODUÇÃO NAS ESTAÇÕES:");
		for (int l = 0; l < linhaProducao; l++) {
			for (int c = 0; c < estacao; c++) {
				System.out.print(tempoDeProducao[l][c] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println("\nMATRIZ DE ANALISE:");
		for (int l = 0; l < linhaProducao; l++) {
			for (int c = 0; c < (estacao-1); c++) {
				System.out.print(analise[l][c] + " ");
			}
			System.out.print("\n");
		}
		
	}
	
	public void leArquivo(String filename){
		
		try {
			
			file = new File(filename);
			
			if (file.exists()){
				
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String [] vLine = br.readLine().split(" ");
							
				int linhas = Integer.parseInt(vLine[0]);
				int estacoes = Integer.parseInt(vLine[1]);
				
				inicializaEstruturas(linhas, estacoes);
				
				vLine = br.readLine().split(" "); // linha nula
				
				vLine = br.readLine().split(" ");
				for (int l = 0; l < linhaProducao; l++) {
					for (int c = 0; c < estacao; c++) {
						processamento[l][c] = Integer.parseInt(vLine[c]);
					}
					vLine = br.readLine().split(" ");
				}
				
				
				vLine = br.readLine().split(" ");
				for (int l = 0; l < linhaProducao; l++) {
					for (int c = 0; c < (estacao - 1); c++) {
						transferencia[l][c] = Integer.parseInt(vLine[c]);
					}
					vLine = br.readLine().split(" ");
				}
				
				vLine = br.readLine().split(" ");
				for (int l = 0; l < linhaProducao; l++) {
					entrada[l] = Integer.parseInt(vLine[l]);
				}
				
				vLine = br.readLine().split(" "); // linha nula
				
				vLine = br.readLine().split(" ");
				
				for (int l = 0; l < linhaProducao; l++) {
					saida[l] = Integer.parseInt(vLine[l]);
				}
				
				br.close();
				
			}
			
		} catch (IOException e) {
			
		}
		
	}
	
	
	public void printData(){
		
		System.out.println("I = " + linhaProducao + "\n" +
						   "J = " + estacao + "\n");
		
		System.out.println("TEMPO:");
		for (int l = 0; l < linhaProducao; l++) {
			for (int c = 0; c < estacao; c++) {
				System.out.print(processamento[l][c] + "  ");
			}
			System.out.println("");
		}
		
		System.out.println("\n");
		
		System.out.println("TRANSFERENCIA:");
		for (int l = 0; l < linhaProducao; l++) {
			for (int c = 0; c < (estacao - 1); c++) {
				System.out.print(transferencia[l][c] + "  ");
			}
			System.out.println("");
		}
		
		System.out.println("\n");
		
		System.out.println("E[0] = " + entrada[0] + "\n" +
						   "E[1] = " + entrada[1]);
		
		System.out.println("\n");
		
		System.out.println("S[0] = " + saida[0] + "\n" +
				   		   "S[1] = " + saida[1]);
		
	}
	
	
	
}
