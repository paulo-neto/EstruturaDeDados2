package br.com.ed2.programacaoGulosa.menorCaminho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapa {

	
	private double [][] cidades;
	private boolean [] visitados;
	private String [] desc_cidades;
	
	
	public Mapa(int dim){
		
		cidades = new double[dim][dim];
		
		desc_cidades = new String[dim];
		for (int l = 0; l < desc_cidades.length; l++) {
			desc_cidades[l] = "(C"+(l+1)+")";
		}
		
		visitados = new boolean[dim];
		initVisitados();
		
	}
	
	
	
	public String getSolucaoAleatoriaMelhor(int saida, int nSolucoes){
		
		double [][] cidadestmp = cidades;
		
		initVisitados();
		
		String rslt = "";
		
		if (saida <= cidadestmp.length) {
			
			double [] solucoes = new double [nSolucoes];
			String [] rotas = new String[nSolucoes];			
			double km;
			int ponteiro;
			List<Cidade> candidatos = new ArrayList<Cidade>();
			
			for (int s = 0; s < nSolucoes; s++) {
				
				rslt = "";
				km = 0;
				ponteiro = 0;				
				
				for (int i = 0; i < cidadestmp.length; i++) {
										
					for (int j = 0; j < cidadestmp[ponteiro].length; j++) {
						if (cidadestmp[ponteiro][j] == 0){
							visitados[j] = true;
						}
					}					
					
					for (int k = 0; k < cidadestmp[i].length; k++) {
						
						if (cidadestmp[ponteiro][k] != 0 && !visitados[k]) {
							Cidade cidade = new Cidade(cidadestmp[ponteiro][k], k);
							candidatos.add(cidade);
						}						
					}					
					
					Collections.sort(candidatos, new CompareDistancia());
					
					int random = (int)(Math.random()*5)%10;			
					if (random >= candidatos.size()) {
						random = 0;
					}
					
					if (!candidatos.isEmpty()) {
						
						visitados[candidatos.get(random).index] = true;
						ponteiro = candidatos.get(random).index;
						rslt += candidatos.get(random).distancia + "\n";
						km += candidatos.get(random).distancia;
						
						candidatos.removeAll(candidatos);
						
					} else {
						
						rslt += cidadestmp[ponteiro][0] + "\n";
						km += cidadestmp[ponteiro][0];						
					}
					
				}
				
				solucoes[s] = km;
				rotas[s] = rslt + "\nDISTÂNCIA TOTAL: " + km + "Km.";
				candidatos.removeAll(candidatos);
				
				initVisitados();
				
			}
			double menor = solucoes[0];
			int index = 0;
			for (int l = 0; l < solucoes.length; l++) {
				if (solucoes[l] < menor){
					menor = solucoes[l];
					index = l;
				}
			}
			rslt = rotas[index];
		}		
		return rslt;		
	}
	
	
	
	public String getSolucaoAleatoria(int saida){
		
		initVisitados();
		
		double [][] cidadestmp = cidades;
		String rslt = "";

		if (saida <= cidadestmp.length) {

			double km = 0;
			int ponteiro = 0;
			List<Cidade> candidatos = new ArrayList<Cidade>();

			for (int i = 0; i < cidadestmp.length; i++) {

				for (int j = 0; j < cidadestmp[ponteiro].length; j++) {
					if (cidadestmp[ponteiro][j] == 0) {
						visitados[j] = true;
					}
				}

				for (int k = 0; k < cidadestmp[i].length; k++) {

					if (cidadestmp[ponteiro][k] != 0 && !visitados[k]) {
						Cidade cidade = new Cidade(cidadestmp[ponteiro][k], k);
						candidatos.add(cidade);
					}
				}

				int random = (int) (Math.random() * 2);
				if (random >= candidatos.size() || random > 10) {
					random = 0;
				}

				if (!candidatos.isEmpty()) {

					visitados[candidatos.get(random).index] = true;
					ponteiro = candidatos.get(random).index;
					rslt += candidatos.get(random).distancia + "\n";
					km += candidatos.get(random).distancia;

					candidatos.removeAll(candidatos);

				} else {

					rslt += cidadestmp[ponteiro][0] + "\n";
					km += cidadestmp[ponteiro][0];
				}				
			}
			
			rslt += "\nDISTÂNCIA TOTAL: " + km + "Km.";
			
		}
		return rslt;		
	}
	
	
	
	public String getSolucaoGulosa(int saida){
		
		initVisitados();
		
		double [][] cidadestmp = cidades;
		String rslt = "";

		if (saida <= cidadestmp.length) {

			double km = 0;
			int ponteiro = 0;
			List<Cidade> candidatos = new ArrayList<Cidade>();

			for (int i = 0; i < cidadestmp.length; i++) {

				for (int j = 0; j < cidadestmp[ponteiro].length; j++) {
					if (cidadestmp[ponteiro][j] == 0) {
						visitados[j] = true;
					}
				}

				for (int k = 0; k < cidadestmp[i].length; k++) {

					if (cidadestmp[ponteiro][k] != 0 && !visitados[k]) {
						Cidade cidade = new Cidade(cidadestmp[ponteiro][k], k);
						candidatos.add(cidade);
					}
				}
				
				Collections.sort(candidatos, new CompareDistancia());

				if (!candidatos.isEmpty()) {

					visitados[candidatos.get(0).index] = true;
					ponteiro = candidatos.get(0).index;
					rslt += candidatos.get(0).distancia + "\n";
					km += candidatos.get(0).distancia;

					candidatos.removeAll(candidatos);

				} else {

					rslt += cidadestmp[ponteiro][0] + "\n";
					km += cidadestmp[ponteiro][0];
				}				
			}
			
			rslt += "\nDISTÂNCIA TOTAL: " + km + "Km.";
			
		}
		return rslt;		
	}
	
	
	
	// Inicializa a lista de cidades visitadas
	private void initVisitados(){
		
		for (int i = 0; i < visitados.length; i ++) {
			visitados[i] = false;
		}
		
	}
	
	/* Preenche linha a linha a matriz de cidades. Recebe do arquivo */
	public void setLinhaMatriz(int nl, double [] linhafile){
		
		for (int c = 0; c < linhafile.length; c++) {			
			cidades[nl][c] = linhafile[c];			
		}
		
	}
	
	
	/* Imprime a matriz das distancias entre as cidades */
	public void printMatriz(){
		System.out.println(" ***** Matriz das distâncias entre as cidades *****");
		System.out.println("---------------------------------");
		for (int l = 0; l < cidades.length; l++) {
			for (int c = 0; c < cidades.length; c++) {
				System.out.print(cidades[l][c] + "  |  ");
			}
			System.out.println("\n---------------------------------");
		}
		
	}
	
	
}
