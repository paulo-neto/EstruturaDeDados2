package br.com.prova2.questao01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MatrizCidades {
	
	
	private BufferedReader br;
	private File file;
	
	private int [][] matrizCidades;
	private boolean [] cidadesVisitadas;
	private int [] solucao;
	private int ponteiro;
	
	
	private void init(int dim){
		
		matrizCidades = new int [dim][dim];
		cidadesVisitadas = new boolean [dim];
		solucao = new int [dim];
		ponteiro = 0;
		
	}

	public void menorCaminhoGuloso(int inicio, int fim) {

		/* guarda as cidades que j� foram visitadas. */
		List<String> nomeCidade = new ArrayList<String>();

		/* adiciona a cidade de origem */
		nomeCidade.add("(" + inicio + ")");

		/* inicializa o ponteiro com a cidade de origem */
		ponteiro = inicio;

		/* inteiro utilizado para obter a menor distnacia de uma linha */
		int menor;

		/* inteiro tempor�rio para auxiliar o ponteiro */
		int ponteiroAux = inicio;

		/* Marca a cidade origem como visitada */
		cidadesVisitadas[inicio] = true;

		/* repeti��o para varrer as N linha(s) */
		for (int l = 0; l < matrizCidades.length; l++) {
			/* obt�m o maior valor inteiro poss�vel */
			menor = Integer.MAX_VALUE;

			/* percorre a coluna (ponteiro) a procura da menor dist�ncia */
			for (int c = 0; c < matrizCidades[ponteiro].length; c++) {

				/*
				 * Se a dist�ncia for maior que 0 e menor que o valor da
				 * vari�vel "menor" e essa posi��o n�o estiver sido visitada,
				 * atualiza o valor escolhido, que est� em solu��o, atualiza a
				 * vari�vel "menor", pois, podem existir outros valores menores
				 * e for fim, atualiza o tmp com a posi��o do valor visitado.
				 */
				if (matrizCidades[ponteiro][c] > 0 && !cidadesVisitadas[c]&& matrizCidades[ponteiro][c] <= menor) {
					solucao[l] = matrizCidades[ponteiro][c];
					menor = matrizCidades[ponteiro][c];
					ponteiroAux = c;
				}
			}

			/* atualiza o ponteiro */
			ponteiro = ponteiroAux;

			/* a posi��o do menor valor foi visitada */
			cidadesVisitadas[ponteiro] = true;

			/* adiciona a cidade visitada */
			nomeCidade.add("(" + String.valueOf(ponteiro) + ")");

			/*
			 * Verifica se a cidade de destino foi visitada, se foi visitada
			 * para imediatamente a execu��o.
			 */
			if (nomeCidade.contains("(" + fim + ")"))
				break;

		}
		
		int cont = 0;

		/*
		 * imprime todas as cidades visitadas e as dist�ncias entre cada uma
		 * delas
		 */
		for (String a : nomeCidade) {

			if (solucao[cont + 1] != 0) {
				System.out.print("Cidade : "+a + " distancia " + solucao[cont] + " para \n");
			} else {
				System.out.print("Cidade : "+a + " distancia " + solucao[cont] + " para (" + fim+ ")\n");
				break;
			}
			cont++;
		}
	}
	
	public void readFile(String filename){
		
		try {
			
			file = new File(filename);
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			if (file.exists()){
				
				String [] str = br.readLine().split(" ");
				if (str.length > 0) {
					
					int x = Integer.parseInt(str[0]);
										
					init(x);
					
					while (br.ready()) {
						
						for (int i = 0; i < matrizCidades.length; i++) {
							
							str = br.readLine().split(" ");
							
							for (int j = 0; j < matrizCidades[i].length; j++) {
							
								matrizCidades[i][j] = Integer.parseInt(str[j]);
								
							}
						}						
					}
					
				}				
			}
			
			br.close();
			
		} catch (IOException ex){
			
			System.out.println("ERRO! leitura do arquivo.");
			
		}
		
	}
}
