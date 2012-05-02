package br.ufpb.ed.pratica05;

public class Caxeiro {
	
	int[][] matrizDistancia;
	int cidadeInicial;
	int distanciaApercorrer;
	
	public Caxeiro(int[][] matrizDistancia, int cidadeInicial) {
		this.matrizDistancia = matrizDistancia;
		this.cidadeInicial = cidadeInicial;
		this.distanciaApercorrer = 0;
	}
	
	public int[] elaborarRotaGulosa(){
		return elaborarRota(matrizDistancia, cidadeInicial);
	}
	
	private int[] elaborarRota(int[][] matrizDistancia, int cidadeInicial){
		int qtdeCidade = matrizDistancia.length;// Diametro da matriz
		boolean[] controle = new boolean[qtdeCidade];// Vetor que controla as cidades já visitadas
		int rotaCaxeiro[] = new int[qtdeCidade+1];// Guarda as cidades que já foram visitadas
		int indexRotaCaxeiro= 0;
		int cidadeCurrent = cidadeInicial;// Cidade Atual
		rotaCaxeiro[indexRotaCaxeiro++] = cidadeCurrent;// o Indice 0 recebe a cidade atual e depois incrementa o valor do indice 
		controle[cidadeCurrent] = true;// Marca a cidade como visitada
		
		while(indexRotaCaxeiro < qtdeCidade){
			int indexCidadeMaixProx = -1;
			int menorDistancia = Integer.MAX_VALUE;
			for(int j =0; j < qtdeCidade; ++j){
				if (controle[j] == false && matrizDistancia[cidadeCurrent][j] < menorDistancia){
					indexCidadeMaixProx = j;
					menorDistancia = matrizDistancia[cidadeCurrent][j];
				}
			}
			cidadeCurrent = indexCidadeMaixProx;
			rotaCaxeiro[indexRotaCaxeiro++] = cidadeCurrent;
			controle[cidadeCurrent] = true;
		}
		rotaCaxeiro[indexRotaCaxeiro] = cidadeInicial;
		return rotaCaxeiro;
	}
	
//	public int calcularDistanciaPercurso(int[] rota){
//		int distancia = 0;
//		for(int i = 0; i < rota.length -1; ++i)
//			distancia += matrizDistancia[rota[i]][rota[i+i]];
//		return distancia;
//	}

}
